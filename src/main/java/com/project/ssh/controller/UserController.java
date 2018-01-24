package com.project.ssh.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.google.api.plus.Person;
import org.springframework.social.google.api.plus.PlusOperations;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.project.ssh.domain.User;
import com.project.ssh.exception.SSHRuntimeException;
import com.project.ssh.loginAPI.NaverLoginBO;
import com.project.ssh.service.UserService;

@Controller
public class UserController {
	
	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;
	
	/* GoogleLogin */
	@Autowired
	private GoogleConnectionFactory googleConnectionFactory;
	@Autowired
	private OAuth2Parameters googleOAuth2Parameters;



	
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO){
		this.naverLoginBO = naverLoginBO;
	}
	
	@Autowired
	private UserService userservice;
	
	
	// 로그인 화면 요청
	/*@RequestMapping("/showLogin.do")
	public String showLogin(){
		
		return "showLogin";
	}
	*/
	
	@RequestMapping(value = "/showLogin.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpSession session) {
		
		/* 구글code 발행 */
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		String googleAuthUrl = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);

		System.out.println("구글:" + googleAuthUrl);

		model.addAttribute("google_url", googleAuthUrl);


		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		
		//https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
		//redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
		System.out.println("네이버:" + naverAuthUrl);
		
		//네이버 
		model.addAttribute("naver_url", naverAuthUrl);
		/* 생성한 인증 URL을 View로 전달 */
		return "showLogin";
	}
	
	// 구글 Callback호출 메소드
		@RequestMapping(value = "/googleLogin.do", method = { RequestMethod.GET, RequestMethod.POST })
		public String googleCallback(Model model, @RequestParam String code, HttpServletRequest req) throws IOException {
			System.out.println("/member/googleSignInCallback");
			  

			  OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
			  AccessGrant accessGrant = oauthOperations.exchangeForAccess(code , googleOAuth2Parameters.getRedirectUri(),
			      null);

			  String accessToken = accessGrant.getAccessToken();
			  Long expireTime = accessGrant.getExpireTime();
			  if (expireTime != null && expireTime < System.currentTimeMillis()) {
			    accessToken = accessGrant.getRefreshToken();
			    System.out.printf("accessToken is expired. refresh token = {}", accessToken);
			  }
			  Connection<Google> connection = googleConnectionFactory.createConnection(accessGrant);
			  Google google = connection == null ? new GoogleTemplate(accessToken) : connection.getApi();

			  PlusOperations plusOperations = google.plusOperations();
			  Person profile = plusOperations.getGoogleProfile();
			  System.out.println(profile);
			  
			  
			  //session.setAttribute("login",  );

			return "googleSuccess";
		}
	


	
	//네이버 로그인 성공시 callback호출 메소드
	@RequestMapping(value = "/naverLogin.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String naverLogin(Model model, @RequestParam String code, @RequestParam String state, HttpSession session, HttpServletRequest req)
			throws IOException {
		
		session = req.getSession();
		OAuth2AccessToken oauthToken;
        oauthToken = naverLoginBO.getAccessToken(session, code, state);
        
        
	    //로그인 사용자 정보를 읽어온다.
	    apiResult = naverLoginBO.getUserProfile(oauthToken);
		model.addAttribute("result", apiResult);
		System.out.println(apiResult);
		
		//jSON형식의 apiResult 를 파싱하여 DB를 조회하고 해당 유저가 없으면 새로 등록한다, 그후 세션에 setAttribute 
		JSONObject obj = new JSONObject(apiResult);
		JSONObject response = obj.getJSONObject("response");
		System.out.println("response : " + response);
		User loginedUser = null;
		if((loginedUser = userservice.findUser(response.getString("email"))) == null){
			User user = new User();
			user.setUserName(response.getString("name"));
			user.setEmail(response.getString("email"));
			user.setPassword("Unnecessary");
			userservice.registUser(user);
		}
		session.setAttribute("loginedUser", loginedUser);
        /* 네이버 로그인 성공 페이지 View 호출 */
		return "redirect:index.do";
	}

	// 회원 가입 화면 요청
	@RequestMapping("/showSignUp.do")
	public String showSignUp(){
		
		return "showSignUp";
	}
	
	// 로그인 실행
	@RequestMapping(value = "/login.do", method= RequestMethod.POST )
	public String login(HttpServletRequest req){
		String userId = req.getParameter("id");
		String password = req.getParameter("password");
		boolean login = userservice.login(userId, password);
		if(login){
			User loginedUser = userservice.findUser(userId);
			if(loginedUser != null){
				HttpSession session = req.getSession();
				session.setAttribute("loginedUser", loginedUser);
			}else{
				HttpSession session = req.getSession();
				session.invalidate();
			}
		} else{
			return "showLogin";	
		}
		
		return "redirect:index.do";
	}




	
	//로그아웃
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "redirect:index.do";
	}
	
	
	// 회웝가입 실행
	@RequestMapping(value = "/registUser.do", method= RequestMethod.POST)
	public String registUser(User user, HttpServletRequest req){
		
		if(userservice.findUser(user.getEmail()) == null){
			userservice.registUser(user);
			return "redirect:index.do";
		}
		return "showJoin.do";
	}
	
	// 개인정보 수정화면 출력
	@RequestMapping("/showUpdateUser.do")
	public ModelAndView showModifyUserInfo(HttpServletRequest req){
		
		
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("loginedUser");
		
		if(user == null){
			SSHRuntimeException ex = new SSHRuntimeException("로그인 후 이용해 주시기 바랍니다");
			throw ex;
		}
		
		ModelAndView mav = null;
		
		mav = new ModelAndView("showUpdateUser");
		
		mav.addObject("InfoUser", user);
		return mav;
	}
	
	// 개인정보 수정
	@RequestMapping(value = "/updateUser.do", method= RequestMethod.POST)
	public String updateUserInfo(HttpServletRequest req){
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("loginedUser");
		String userName = req.getParameter("userName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String confirm = req.getParameter("confirm");
		User updatedUser = null;
		if(!password.equals(confirm)){
			SSHRuntimeException ex = new SSHRuntimeException("입력한 비밀번호가 서로 다릅니다");
			throw ex;
		} else if(!(password.equals(user.getPassword()))) {
			SSHRuntimeException ex = new SSHRuntimeException("입력한 비밀번호가 올바르지 않습니다");
			throw ex;
		}else{
			updatedUser = new User(user.getUserId(), userName, password, email);
		}
		userservice.modifyUser(updatedUser);
		session.setAttribute("loginedUser", updatedUser);
		return "redirect:index.do";
	}
	

	
	
	//회원가입 유효성 확인
	@RequestMapping("/checkId.do")
	   public @ResponseBody String checkId(String loginId){
	     
	      
	      User user = userservice.findUser(loginId);
	      if(user != null){
		      String userId = user.getUserId();
		      if(userId.equals(loginId)){
		    	  return "true";
		      }
	      }
	      return "false";
	   }
	
	protected String uniToKsc(String uni) throws UnsupportedEncodingException{

	     return new String (uni.getBytes("8859_1"),"KSC5601");

	 }

	
	
}
