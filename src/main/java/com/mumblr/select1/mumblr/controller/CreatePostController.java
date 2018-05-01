package com.mumblr.select1.mumblr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mumblr.select1.mumblr.model.Posts;

@Controller
public class CreatePostController {
	
	@RequestMapping(value="/createPost", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Posts post){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("postDetails");
		return modelAndView;
	}
}
