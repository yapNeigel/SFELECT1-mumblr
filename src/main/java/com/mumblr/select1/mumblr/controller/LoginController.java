package com.mumblr.select1.mumblr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView find(@RequestParam("emailLogin") String email,@RequestParam("passLogin") String pass, HttpSession httpSession){
		StrongPasswordEncryptor spe = new StrongPasswordEncryptor();

		Accounts acc = ur.findByemail(email);
		ModelAndView modelAndView = new ModelAndView();
		

		if(acc.getEmail().isEmpty()){
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
