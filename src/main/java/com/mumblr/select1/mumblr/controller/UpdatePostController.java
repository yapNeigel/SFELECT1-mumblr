package com.mumblr.select1.mumblr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mumblr.select1.mumblr.model.Posts;
import com.mumblr.select1.mumblr.repository.PostsRepository;

@Controller
public class UpdatePostController {
	@Autowired
	private PostsRepository pr;
	
	@RequestMapping(value="/updatepost", method=RequestMethod.POST)
	public ModelAndView save(HttpSession httpSession, @RequestParam(value="updContent", required=false) String updContent, @RequestParam(value="postID", required=false) String postID){
		ModelAndView modelAndView = new ModelAndView();
		Posts post = pr.findByid(postID);
		post.setContent(updContent);
		pr.save(post);
		modelAndView.setViewName("redirect:/home");
		return modelAndView;
	}
}
