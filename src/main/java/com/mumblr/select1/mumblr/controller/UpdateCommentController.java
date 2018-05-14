package com.mumblr.select1.mumblr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mumblr.select1.mumblr.model.Comments;
import com.mumblr.select1.mumblr.repository.CommentRepository;


@Controller
public class UpdateCommentController {
	@Autowired
	private CommentRepository cr;
	
	@RequestMapping(value="/editcomment", method=RequestMethod.POST)
	public ModelAndView save(HttpSession httpSession, @RequestParam(value="editCommentContent", required=false) String editContent, @RequestParam(value="commentID", required=false) String commentID){
		ModelAndView modelAndView = new ModelAndView();
		Comments comment = cr.findByid(commentID);
		comment.setCommentContent(editContent);
		cr.save(comment);
		modelAndView.setViewName("redirect:/home");
		return modelAndView;
	}
}
