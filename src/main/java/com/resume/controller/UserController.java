package com.resume.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.resume.entities.UserDtls;
import com.resume.helper.Message;
import com.resume.repository.UserRepo;
import com.resume.service.Service;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private Service service;
	static int ID;

	@Autowired
	private UserRepo userrepo;
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("title","login form");
		return "login";
	}
	@GetMapping("/homepage")
	public String index9() {
		return "index9";
	}
	@GetMapping("/about")
	public String about() {
		return "about";
	}

	//register
	@RequestMapping("/home")
	public String userhome(Model model) {
		model.addAttribute("title","register");
		model.addAttribute("user",new UserDtls());
		return "index";
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
	@GetMapping("/resume")
	public String template() {
		return "resume";
	}
	@GetMapping("/template1")
	public String template1() {
		return "template1";
	}
	@GetMapping("/new7")
	public String new1() {
		return "new7";
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	
	@GetMapping("/index1")
	public String index1() {
		return "index1";
	}
	@GetMapping("/NewFile")
	public String NewFile() {
		return "NewFile";
	}
	

	@GetMapping("/NewFile1")
	public String NewFile1() {
		return "NewFile1";
	}

	@GetMapping("/NewFile3")
	public String NewFile3() {
		return "NewFile3";
	}
	@GetMapping("/landingpage1")
	public String land( Model model, Principal p) {
		String name=p.getName();
		UserDtls d=userrepo.getUserByUserName(name);
		model.addAttribute("user", d);
		return "landingpage1";
	}
	
	
	
	@GetMapping("/profile")
	public String profile(Model model, Principal p) {
		String name=p.getName();
		UserDtls d = userrepo.getUserByUserName(name);
		System.out.println(d);
		System.out.println(name);
		model.addAttribute("user",d);
		return "add_profile_form";
	}
	
	
	
	
	@GetMapping("/edit/{id}")
	public String postEdit(@PathVariable("id") int id,@ModelAttribute UserDtls e ,Model m,Principal p) {
		
		String name=p.getName();
		System.out.println(id);
		UserDtls user= userrepo.getById(id);
		
		user.setName(e.getName());
			userrepo.save(user);
		m.addAttribute("user",user);
		return "add_profile_form";
		
	}
	
}
	

