package com.coding.cafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coding.cafe.entity.User;
import com.coding.cafe.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserService userser;
	public UserController(UserService userser) {
		this.userser=userser;
	}
	
//	@PostMapping("/saveUser")
//	public User saveUser(@RequestBody User theUser) {
//		return userser.addUser(theUser);
//	}
	
	
	
//	@PostMapping("/addUser")
//	public String addUser(@RequestParam("name")String name,
//			@RequestParam("email")String email,
//			@RequestParam("password")int password , RedirectAttributes res){
//		
//		boolean emailExists = userser.checkEmail(email);
//		if(emailExists == false)
//		{
//	      User user = new User();
//	      user.setName(name);
//	      user.setEmail(email);
//	      user.setPassword(password);
//	      userser.addUser(user);
//	      res.addFlashAttribute("success", "Registration Successful...!");
//	      return "redirect:/login";
//		}
//		else
//		{
//			 res.addFlashAttribute("success", "Already Register...!");
//			return "redirect:/signup";
//		}
//	}
	  
	
	
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute User user) 
	{
		//email taken from registration form
		String email = user.getEmail();

		//checking if the email as entered in registration  form 
		// is present in DB or not.
		boolean status = userser.checkEmail(email);

		if(status == false) {
			userser.addUser(user);
			System.out.println("User added");
		}
		else {
			System.out.println("User already exists");
		}

		return "login";
	}
	
//	@PostMapping("/validate")
//	public String Validate(@RequestParam("email")String email,
//			@RequestParam("password")String password, RedirectAttributes res) {
//		boolean val =userser.validate(email, password);
//		//if user is valid
//		if(val == true)
//		{
//			return "home";
//		}
//					
//		else
//		{
//			res.addFlashAttribute("sucess", "Incorrect Credentials.Try again...!");
//			return "login";
//		}
//	}
	
	
	
	
	@PostMapping("/validate")
	public String Validate(@RequestParam("email") String email,
			@RequestParam("password") String password, HttpSession session, Model model) {

		if(userser.validate(email, password) == true){
			return "redirect:/home";
		}	
		else {
			return "redirect:/login";
		}	 
	}
	
	@GetMapping("/signout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}

}
