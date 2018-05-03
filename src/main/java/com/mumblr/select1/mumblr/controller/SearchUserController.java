package com.mumblr.select1.mumblr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mumblr.select1.mumblr.model.Accounts;
import com.mumblr.select1.mumblr.repository.UserRepository;

@Controller
public class SearchUserController {
	@Autowired
	private UserRepository ur;
	
	@RequestMapping(value="/searchuser", method=RequestMethod.GET)
	public ModelAndView find(@RequestParam("searchName") String fullName){
		ModelAndView modelAndView = new ModelAndView();
		List<Accounts> userAccs = ur.findByfullNameLikeIgnoreCase(fullName);
		modelAndView.setViewName("search");
		modelAndView.addObject("query", fullName);
		modelAndView.addObject("users", userAccs);
		return modelAndView;
	}
}
