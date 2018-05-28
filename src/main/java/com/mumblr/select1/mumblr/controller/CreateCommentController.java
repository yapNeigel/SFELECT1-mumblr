package com.mumblr.select1.mumblr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mumblr.select1.mumblr.model.Comments;
import com.mumblr.select1.mumblr.repository.CommentRepository;
import com.mumblr.select1.mumblr.repository.PostsRepository;
import com.mumblr.select1.mumblr.repository.UserRepository;

@Controller
public class CreateCommentController {
	@Autowired
	private PostsRepository pr;
	@Autowired
	private UserRepository ur;
	@Autowired
	private CommentRepository cr;
	
	@RequestMapping(value="/addcomment", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Comments comment){
		ModelAndView modelAndView = new ModelAndView();
		cr.save(comment);
		modelAndView.setViewName("redirect:/home");
		return modelAndView;
	}
}
