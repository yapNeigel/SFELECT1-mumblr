package com.mumblr.select1.mumblr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mumblr.select1.mumblr.repository.CommentRepository;

@Controller
public class DeleteCommentController {
	@Autowired
	private CommentRepository cr;
	
	@RequestMapping(value="/deletecomment", method=RequestMethod.POST)
	public ModelAndView save(HttpSession httpSession, @RequestParam(value="delCommentId", required=false) String commentID){
		ModelAndView modelAndView = new ModelAndView();
		cr.deleteByid(commentID);
		modelAndView.setViewName("redirect:/home");
		return modelAndView;
	}
}
