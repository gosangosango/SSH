package com.project.ssh.controller;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.project.ssh.domain.Device;
import com.project.ssh.domain.ElectronData;
import com.project.ssh.domain.User;
import com.project.ssh.service.DeviceService;
import com.project.ssh.service.ElectronDataService;


@Controller
public class DataController {

	@Autowired
	private ElectronDataService electronDataService;
	
	@Autowired
	private DeviceService deviceService;
	
	@RequestMapping("/getData.do")
	public ResponseEntity<String> getData(HttpServletRequest req) throws IOException{
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
		
		
		System.out.println("electorn 에서의 접근");
		
		
		String body = getBody(req);
		System.out.println("requestBody : " + body);
		
		Date date = new Date(System.currentTimeMillis());
		
	    ElectronData electronData = new ElectronData();
		
		Gson gson = new Gson();
		if(body.length() > 0){
			electronData = gson.fromJson(body, ElectronData.class);
		}
		if(electronData.getKind().equals("Location")){
			electronData.setChecked("Y");
		}else{
			electronData.setChecked("N");
		}
		electronData.setReceivedDate(date.toString());
		System.out.println("ElectronData To String(Object to string)" + electronData.toString());
		electronDataService.createData(electronData);

		
		return new ResponseEntity<String>(body, responseHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping("/showData.do")
	   public ModelAndView showData(HttpServletRequest req) {
		
		  String deviceId = (String)req.getParameter("deviceId");
	      ModelAndView modelAndView = new ModelAndView("showData");
	      List<ElectronData> datas = new ArrayList<ElectronData>();
	      datas = electronDataService.retrieveNewestData(deviceId);
	      System.out.println(datas.toString());
	      modelAndView.addObject("datas",datas);
	      return modelAndView;
	   }
	
	@RequestMapping(value="/uncheckedData.do", headers="Accept=*/*", method=RequestMethod.GET)
	public @ResponseBody String uncheckedData(HttpServletRequest req){
		User loginedUser = null;
		if((loginedUser = (User)req.getSession().getAttribute("loginedUser")) != null){
			String userId = loginedUser.getUserId();
			List<ElectronData> datas = new ArrayList<ElectronData>();
			List<Device> devices = deviceService.findDevicesByOwner(userId);
			for(Device device : devices){
				datas.addAll(electronDataService.retrieveUncheckedData(device.getDeviceId()));
			}
			int size = datas.size();
			if(size != 0){
				for(ElectronData data : datas){
					data.setChecked("Y");
					electronDataService.updateData(data);
				}
			}
				return Integer.toString(size);
		}
		return "0";
	}
	

	
    public static String getBody(HttpServletRequest request) throws IOException {
   	  
        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
 
        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }
 
        body = stringBuilder.toString();
        return body;
    }
	
	
	
}
