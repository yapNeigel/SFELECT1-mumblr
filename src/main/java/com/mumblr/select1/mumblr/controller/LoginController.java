package com.mumblr.select1.mumblr.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mumblr.select1.mumblr.model.Accounts;
import com.mumblr.select1.mumblr.model.Comments;
import com.mumblr.select1.mumblr.model.Follow;
import com.mumblr.select1.mumblr.model.Posts;
import com.mumblr.select1.mumblr.repository.CommentRepository;
import com.mumblr.select1.mumblr.repository.FollowRepository;
import com.mumblr.select1.mumblr.repository.PostsRepository;
import com.mumblr.select1.mumblr.repository.UserRepository;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class LoginController {
	@Autowired
	private UserRepository ur;
	@Autowired
	private PostsRepository pr;
	@Autowired
	private FollowRepository fr;
	@Autowired
	private CommentRepository cr;
	
	@RequestMapping(value="/home")
	public String home(HttpSession httpSession, Model model){
		
		if(httpSession.getAttribute("userAcc") != null){
			Accounts acc = (Accounts) httpSession.getAttribute("userAcc");
			List<Posts> posts = new ArrayList<>();
			List<Comments> comments = new ArrayList<>();
			List<Posts> userPosts = pr.findByPosterID(acc.getId());
			List<Follow> followers = fr.findByuserID(acc.getId());
			
			posts.addAll(userPosts);
			
			if(followers != null){
				for(Follow follower : followers){
					List<Posts> followerPost = pr.findByPosterID(follower.getFollowersID());
					posts.addAll(followerPost);
				}
			}
			
			Collections.sort(posts);
			Collections.reverse(posts);
			
			for(Posts post : posts){
				List<Comments> comment = cr.findBypostId(post.getId());
				comments.addAll(comment);
			}
			
			model.addAttribute("userPosts", posts);
			model.addAttribute("comments", comments);
			return "home";
		} 

		return "index";
	}
	
	
	@RequestMapping(value="/login", method={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView find(@RequestParam(value="emailLogin", required=false) String email,@RequestParam(value="passLogin", required=false) String pass, HttpSession httpSession){
	
		ModelAndView modelAndView = new ModelAndView();
		
		if(email == null || pass == null || email.isEmpty() || pass.isEmpty()){
			modelAndView.setViewName("index");
		} else {
			StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
			Accounts acc = ur.findByemail(email);
			
			if(acc.getEmail().isEmpty() || acc.getEmail() == null){
				modelAndView.setViewName("index");
			}else{
				if(spe.checkPassword(pass, acc.getPass())){
					httpSession.setAttribute("userAcc", acc);
					modelAndView.setViewName("redirect:/home");
				}else{
					modelAndView.setViewName("index");
				}
			}	
		}
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession httpSession, Model model){
		
		if(httpSession.getAttribute("userAcc") != null){
			httpSession.invalidate();
			return "index";
		} 

		return "index";
	}
}
