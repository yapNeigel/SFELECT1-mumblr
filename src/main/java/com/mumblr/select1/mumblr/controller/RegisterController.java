package com.mumblr.select1.mumblr.controller;

import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;

import com.mumblr.select1.mumblr.model.Accounts;
import com.mumblr.select1.mumblr.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  

@Controller  
public class RegisterController {
	
	@Autowired
	private UserRepository ur;
	
	@RequestMapping("/")  
	public String index(){  
		return "index";  
	}
	@RequestMapping(value="/registered", method=RequestMethod.POST)  
	public ModelAndView save(@ModelAttribute Accounts register){
		ur.save(register);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("registeruser");      
		modelAndView.addObject("registeredUser", register);    
		return modelAndView;  
	} 
}