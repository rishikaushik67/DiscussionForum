package com.mum.discussionforum.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mum.discussionforum.domain.Comment;
import com.mum.discussionforum.domain.Post;
import com.mum.discussionforum.domain.User;
import com.mum.discussionforum.service.DiscussionFormService;
import com.mum.discussionforum.service.UserService;

@SessionAttributes({"currentuser","posts"})
@Controller
public class DiscussionFormController {


	@Autowired
	UserService userservice;
	
	@Autowired
	DiscussionFormService discussionformservice;
	
	@RequestMapping(value="/forum",method=RequestMethod.GET)
	public String discussionForum(@ModelAttribute("post") Post post,@ModelAttribute("comment") Comment comment,
			Model model,HttpSession session){
		User user=(User)session.getAttribute("currentuser");
	System.out.println("inside form controller"+user.getUserCredentials().getUserName());
	
	model.addAttribute("posts",discussionformservice.getAllQuestions());
	
	return "forum";
	}
	
	@RequestMapping(value="/postdiscussion",method=RequestMethod.POST)
	public @ResponseBody List<Post> postQuestion(@ModelAttribute("post") Post post,HttpSession session,Model model){
		User user=(User) session.getAttribute("currentuser");
	
		post.setUser(user);
		discussionformservice.postQuestion(post);
		
		List<Post> posts=discussionformservice.getAllQuestions();
		return posts;
	}
	
	
	/*@RequestMapping(value="/postdiscussion",method=RequestMethod.POST)
	public String postQuestion(@ModelAttribute("post") Post post,HttpSession session,Model model){
		User user=(User) session.getAttribute("currentuser");
	
		post.setUser(user);
//		user.addPosts(post);
		discussionformservice.postQuestion(post);
		
		return "redirect:/forum";
	
	}*/
	
	@RequestMapping(value="/postcomment/{postId}",method=RequestMethod.POST)
	public String postComment(@PathVariable int postId,@ModelAttribute("comment") Comment comment,HttpSession session,Model model){
		System.out.println("Inside post comment");
		User user=(User) session.getAttribute("currentuser");
		
		Post post=discussionformservice.getPost(postId);
		comment.setPost(post);
		comment.setUser(user);
		discussionformservice.postComment(comment);
		
		return "redirect:/forum";
	
	}
}
