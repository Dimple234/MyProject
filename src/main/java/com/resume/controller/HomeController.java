package com.resume.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.resume.entities.UserDtls;
import com.resume.repository.UserRepo;
import com.resume.service.Service;

	@Controller
	public class HomeController {
		@Autowired
		private Service service;
		@Autowired
		private UserRepo userrepo;
		
		
		@Autowired
		BCryptPasswordEncoder passwordEncoder;
		
		@GetMapping("/homepage")
		public String index9() {
			return "index9";
		}
		@GetMapping("/about")
		public String about() {
			return "about";
		}
		

		@GetMapping("/login")
		public String login(Model model) {
			model.addAttribute("title","login form");
			return "login";
		}
		
		
		
		//register
		@RequestMapping("/home")
		public String userhome(Model model) {
			model.addAttribute("title","register");
			model.addAttribute("user",new UserDtls());
			return "index";
		}
		
		@PostMapping("/regist")
		public String register(@ModelAttribute("user") UserDtls u ) {
			u.setRole("ROLE_USER");
			System.out.println(u);
			u.setPassword(passwordEncoder.encode(u.getPassword()));
			userrepo.save(u);
			return"login";
		}
		

		
		
		
		@GetMapping("/resume1")
		public String resume1() {
			return "resume1";
		}
		
		
		@GetMapping("/resume3")
		public String resume3() {
			return "resume3";
		}
		
		
		@GetMapping("/resume2")
		public String resume2() {
			return "resume2";
		
		}
		
		
		@GetMapping("/contact")
		public String contact() {
			return "contact";
		}
		
		
		@GetMapping("/index1")
		public String index1() {
			return "index1";
		}
		
		

		@GetMapping("/landingpage1")
		public String land() {
			return "landingpage1";
		}

		
		
		
		
		
		


		

			
	}

