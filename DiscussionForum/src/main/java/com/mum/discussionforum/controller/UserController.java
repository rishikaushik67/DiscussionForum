package com.mum.discussionforum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mum.discussionforum.domain.User;
import com.mum.discussionforum.domain.UserCredentials;
import com.mum.discussionforum.service.UserService;

@SessionAttributes({"currentuser","login"})
@Controller
public class UserController {

	@Autowired
	UserService userservice;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("login", "login");
		return "welcome";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String home(@ModelAttribute("user") User user,Model model) {
		model.addAttribute("user",user);
		
		return "signup";
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public String userSignup(@ModelAttribute("user") User user, Model model){
		
		userservice.userSignUp(user);
		model.addAttribute("currentuser",user);
		System.out.println(user.getFirstName()+user.getLastName());
		return "redirect:/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getLogin(@ModelAttribute("userCredential") UserCredentials userCredential,Model model){
		System.out.println("Inside Getlogin");
		return "login";
	}
	
	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String logFailed(@ModelAttribute("userCredential") UserCredentials userCredential,Model model) {
		model.addAttribute("login", "login");
		return "login";
	}
	
	@RequestMapping(value="/postlogin",method=RequestMethod.POST)
	public String userLogin(@ModelAttribute("userCredential") UserCredentials userCredential,Model model){
		User user=userservice.userLogin(userCredential);
		model.addAttribute("login", "");
		if(user !=null){
//			user.setUserCredentials(userCredential);
			model.addAttribute("currentuser", user);
//			redirectAttributes.addFlashAttribute("currentuser", user);
			System.out.println("inside forum");
		return "redirect:/forum";
		}else{
			System.out.println("inside login");
			return "login";
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(Model model) {
		model.addAttribute("login", "login");
		return "welcome";
	}
}
