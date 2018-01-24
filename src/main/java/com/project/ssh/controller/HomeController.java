package com.project.ssh.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class HomeController {



	@RequestMapping("/")
	public String main() {
		return "redirect:index.do";
	}

	@RequestMapping("/index.do")
	public ModelAndView showIndex() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}
	
	@RequestMapping("/showAboutUs.do")
	public ModelAndView showAboutUs() {
		ModelAndView modelAndView = new ModelAndView("showAboutUs");
		return modelAndView;
	}
	


}
