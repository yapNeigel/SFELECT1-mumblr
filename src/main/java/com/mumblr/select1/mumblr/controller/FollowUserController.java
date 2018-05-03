package com.mumblr.select1.mumblr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mumblr.select1.mumblr.model.Accounts;
import com.mumblr.select1.mumblr.model.Follow;
import com.mumblr.select1.mumblr.repository.FollowRepository;
import com.mumblr.select1.mumblr.repository.UserRepository;

@Controller
public class FollowUserController {

	@Autowired
	private FollowRepository fr;
	@Autowired
	private UserRepository ur;
	
	@RequestMapping(value="/followuser", method=RequestMethod.POST)
	public ModelAndView save(@RequestParam("follow_btn") String followID, @RequestParam("searchQuery") String query, HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		Accounts acc = (Accounts) session.getAttribute("userAcc");
		Follow details = new Follow();
		details.setUserID(acc.getId());
		details.setFollowersID(followID);
		fr.save(details);
		modelAndView.addObject("searchName", query);
		modelAndView.setViewName("redirect:/searchuser");
		
		return modelAndView;
	}
	
}
