package com.project.ssh.service.Impl;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.project.ssh.dao.UserDao;
import com.project.ssh.dao.Impl.UserDaoImpl;
import com.project.ssh.domain.User;
import com.project.ssh.exception.SSHRuntimeException;
import com.project.ssh.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {


	@Autowired
	private UserDao userdao;
	
	public UserServiceImpl(){
		userdao = new UserDaoImpl();
	}

	public boolean registUser(User user) {
		return userdao.createUser(user);
	}

	@Override
	public boolean modifyUser(User user) {
		return userdao.updateUser(user);
	}

	@Override
	public User findUser(String userId) {
		return userdao.retrieveUser(userId);
	}

	@Override
	public boolean removeUser(String userId) {
		return userdao.deleteUser(userId);
	}

	

	@Override
	public boolean login(String userId, String password) {
		User loginuser = findUser(userId);
		
		if(loginuser == null){
				SSHRuntimeException ex = new SSHRuntimeException("없는 아이디거나 비밀번호가 일치하지 않습니다.");
				ex.setRedirectURL("/showLogin.do");
				throw ex;
		}
		
		if(loginuser.getEmail().equals(userId) && loginuser.getPassword().equals(password)){
			return true;
		}
		return false;
	}




	
	public User checkLogin(HttpServletRequest req){
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("loginedUser");
		if(user == null){
			SSHRuntimeException ex = new SSHRuntimeException("로그인이 필요한 서비스 입니다   로그인 페이지로 이동합니다.");
			ex.setRedirectURL("/showLogin.do");
			throw ex;
		}
		
		return user;
	}



}
