package com.coding.cafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/home")
	public String Home() {
		return "home";
	}
	
	
	@GetMapping("/login")
	public String Login() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String SignUp() {
		return "signup";
	}
	
	@GetMapping("/courses")
	public String Courses() {
		return "courses";
	}
	
	@GetMapping("/contact")
	public String Contact() {
		return "contact";
	}
	
	@GetMapping("/backend")
	public String Backend() {
		return "backend";
	}
	
	@GetMapping("/database")
	public String Database() {
		return "database";
	}
	
	@GetMapping("/dsa")
	public String Dsa() {
		return "dsa";
	}
	
	@GetMapping("/frontend")
	public String Frontend() {
		return "frontend";
	}
	
	@GetMapping("/mern")
	public String MERN() {
		return "mern";
	}
	
	@GetMapping("/roadmaps")
	public String Roadmaps() {
		return "roadmaps";
	}
	

	
}
