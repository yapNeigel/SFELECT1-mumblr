package com.mumblr.select1.mumblr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mumblr.select1.mumblr.model.Accounts;
import com.mumblr.select1.mumblr.repository.UserRepository;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class LoginController {
	@Autowired
	private UserRepository ur;
	
	
	@RequestMapping(value="/home")
	public String home(HttpSession httpSession){
		
		if(httpSession.getAttribute("userAcc") != null){
			return "home";
		} 

		return "index";
	}
	
	
	@RequestMapping(value="/login", method={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView find(@RequestParam(value="emailLogin", required=false) String email,@RequestParam(value="passLogin", required=false) String pass, HttpSession httpSession){
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(email == null || pass == null){
			modelAndView.setViewName("index");
		} else {
			StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
			Accounts acc = ur.findByemail(email);
			
			if(acc.getEmail().isEmpty() || acc.getEmail() == null){
				modelAndView.setViewName("index");
			}else{
				if(spe.checkPassword(pass, acc.getPass())){
					modelAndView.setViewName("home");
					modelAndView.addObject("loginUser", acc);
					httpSession.setAttribute("userAcc", acc);
				}else{
					modelAndView.setViewName("index");
				}
			}	
		}
		
		return modelAndView;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/validating", method=RequestMethod.POST)
	public boolean validate(HttpSession httpSession){
		
		if(httpSession.getAttribute("userAcc") != null){
			
		} else {
			return false;
		}

		return true;
	}
}
