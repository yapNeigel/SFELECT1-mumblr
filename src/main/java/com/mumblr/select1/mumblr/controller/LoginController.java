package com.mumblr.select1.mumblr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mumblr.select1.mumblr.model.Accounts;
import com.mumblr.select1.mumblr.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class LoginController {
	@Autowired
	private LoginRepository lr;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView find(@RequestParam("email") String email,@RequestParam("pass") String pass){
//		lr.findByemailAndpass(email,pass);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		modelAndView.addObject("loginUser", lr.findByEmailAndPass(email,pass));
		return modelAndView;
	}
}
