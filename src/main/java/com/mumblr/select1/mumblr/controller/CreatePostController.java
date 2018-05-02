package com.mumblr.select1.mumblr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mumblr.select1.mumblr.model.Accounts;
import com.mumblr.select1.mumblr.model.Posts;
import com.mumblr.select1.mumblr.repository.PostsRepository;
import com.mumblr.select1.mumblr.repository.UserRepository;

@Controller
public class CreatePostController {
	@Autowired
	private PostsRepository pr;
	@Autowired
	private UserRepository ur;
	
	@RequestMapping(value="/createpost", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Posts post){
		ModelAndView modelAndView = new ModelAndView();
		Accounts acc = ur.findByid(post.getPosterID());
		String posterName = acc.getFname() + " " + acc.getLname();
		post.setPoster(posterName);
		pr.save(post);
		modelAndView.setViewName("redirect:/home");
		return modelAndView;
	}
}
