package com.project.ssh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.ssh.domain.Device;
import com.project.ssh.domain.ElectronData;
import com.project.ssh.domain.User;
import com.project.ssh.exception.SSHRuntimeException;
import com.project.ssh.service.DeviceService;

@Controller
public class DeviceController {
	
	@Autowired
	private DeviceService deviceService;
	
	@RequestMapping("/showDevices.do")
	public ModelAndView showDevices(HttpServletRequest req){
		HttpSession session = req.getSession();
		User loginedUser = (User)session.getAttribute("loginedUser");
		List<Device> devices = null;
		if(loginedUser == null){
			SSHRuntimeException ex = new SSHRuntimeException("로그인 후 이용해 주시기 바랍니다");
			throw ex;
		}else {
			devices = deviceService.findDevicesByOwner(loginedUser.getUserId());
		}
		
		ModelAndView modelAndView = new ModelAndView("showDevices");
		modelAndView.addObject("devices", devices);
		return modelAndView;
	}
	
	@RequestMapping("/showRegistDevice.do")
	public String showRegistDevice(){
		return "showRegistDevice";
	}
	
	//기기등록
	@RequestMapping(value = "/registDevice.do", method= RequestMethod.POST)
	public String registDevice(Device device, HttpServletRequest req){
		HttpSession session = req.getSession();
		User loginedUser = (User) session.getAttribute("loginedUser");
		device.setDeviceOwner(loginedUser.getUserId());
		if(deviceService.findDevice(device.getDeviceId()) == null){
			deviceService.registDevice(device);
			return "redirect:showDevices.do";
		}else {
			SSHRuntimeException ex = new SSHRuntimeException("이미 등록된 디바이스입니다. Device ID를 확인해 주세요");
			throw ex;
		}
		
		
	}
	
	//기기정보 수정
	@RequestMapping(value = "/updateDevice.do", method= RequestMethod.POST)
	public String updateDeviceInfo(Device device, HttpServletRequest req){
		HttpSession session = req.getSession();
		User loginedUser = (User) session.getAttribute("loginedUser");
		device.setDeviceOwner(loginedUser.getUserId());
		
		deviceService.modifyDevice(device);
		
		return "redirect:showDevices.do";
	}
	
	@RequestMapping("/deleteDevice.do")
	public String deleteDevice(HttpServletRequest req){
		String deviceId = (String) req.getParameter("deviceId");
		deviceService.removeDevice(deviceId);
		return "redirect:showDevices.do";
	}
	
	
	@RequestMapping("/showUpdateDevice.do")
	public ModelAndView showUpdateDevice(HttpServletRequest req){
		String deviceId = req.getParameter("deviceId");
		Device device = deviceService.findDevice(deviceId);
		ModelAndView modelAndView = new ModelAndView("showUpdateDevice");
		modelAndView.addObject("device", device);
		return modelAndView;
	}
	
	
	
	
	
}
