package com.mumblr.select1.mumblr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.mumblr.select1.mumblr.repository.FollowRepository;

@Controller
public class UnfollowUserController {
	@Autowired
	private FollowRepository fr;
	
	@RequestMapping(value="/unfollowuser", method=RequestMethod.POST)
	public ModelAndView save(@RequestParam("userID") String userID, @RequestParam("unfollow_btn") String followID, @RequestParam("searchQuery") String query, HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		fr.deleteByid(followID);
		modelAndView.addObject("searchQuery", query);
		modelAndView.addObject("view_btn", userID);
		modelAndView.setViewName("redirect:/viewprofile");
		
		return modelAndView;
	}
}
