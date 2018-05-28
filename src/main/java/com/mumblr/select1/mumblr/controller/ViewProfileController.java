package com.mumblr.select1.mumblr.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mumblr.select1.mumblr.model.Accounts;
import com.mumblr.select1.mumblr.model.Comments;
import com.mumblr.select1.mumblr.model.Follow;
import com.mumblr.select1.mumblr.model.Posts;
import com.mumblr.select1.mumblr.repository.CommentRepository;
import com.mumblr.select1.mumblr.repository.FollowRepository;
import com.mumblr.select1.mumblr.repository.PostsRepository;
import com.mumblr.select1.mumblr.repository.UserRepository;

@Controller
public class ViewProfileController {
	
	@Autowired
	private UserRepository ur;
	@Autowired
	private PostsRepository pr;
	@Autowired
	private CommentRepository cr;
	@Autowired
	private FollowRepository fr;
	
	@RequestMapping(value="/viewprofile", method={RequestMethod.POST, RequestMethod.GET})
	public String find(@RequestParam(value="view_btn", required=false) String searchId,@RequestParam(value="searchQuery", required=false) String query, HttpSession httpSession, Model model){
		
		if(httpSession.getAttribute("userAcc") != null){
			Accounts acc = (Accounts) httpSession.getAttribute("userAcc");
			List<Comments> comments = new ArrayList<>();
			List<Posts> userPosts = pr.findByPosterID(searchId);
			List<Follow> followers = fr.findByuserID(acc.getId());
			Follow check = new Follow();
			
			Collections.sort(userPosts);
			Collections.reverse(userPosts);
			
			for(Posts post : userPosts){
				List<Comments> comment = cr.findBypostId(post.getId());
				comments.addAll(comment);
			}
			
			for(Follow follow : followers){
				if(follow.getFollowersID().equals(searchId)){
					check.setId(follow.getId());
					check.setUserID(follow.getUserID());
					check.setFollowersID(follow.getFollowersID());
				}
			}
			
			if(check != null){
				model.addAttribute("followStatus", check);
				System.out.println("hello");
			}
			System.out.println(check.getUserID());
			model.addAttribute("user", searchId);
			model.addAttribute("userPosts", userPosts);
			model.addAttribute("comments", comments);
			return "profile";
		} 

		return "index";
	}
}
