package com.mumblr.select1.mumblr.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.ui.Model;
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
	private static final String passPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$";
	private Pattern pattern;
	private Matcher matcher;
	
	
	@RequestMapping("/")  
	public String index(){  
		return "index";  
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Accounts register, Model model){
		
		ModelAndView modelAndView = new ModelAndView();
		
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		String encryptedPassword = passwordEncryptor.encryptPassword(register.getPass());
		
		pattern = Pattern.compile(passPattern);
		matcher = pattern.matcher(register.getPass());
		String errorMsg = "Properly fill out the following fields: ";
		List<String> error = new ArrayList<String>();
		
		if(register.getFname().isEmpty()){
			error.add("First Name");
		}
		
		if (register.getLname().isEmpty()){
			error.add("Last Name");
		}
		
		if(register.getEmail().isEmpty()){
			error.add("Email");
		}
		
		if(!matcher.matches()){
			error.add("Password");
		}
		
		if(error.size() > 0){
			error.toArray();
			String errors = String.join(", ", error);
			errorMsg = errorMsg + errors;
			model.addAttribute("errorMsg", errorMsg);
			modelAndView.addObject("details", register);
			modelAndView.setViewName("index");
		} else {
			register.setPass(encryptedPassword);
			ur.save(register);
			modelAndView.setViewName("registeruser");      
			modelAndView.addObject("registeredUser", register);
		}
   
		return modelAndView;  
	} 
}