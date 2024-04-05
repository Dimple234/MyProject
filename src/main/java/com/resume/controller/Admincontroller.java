package com.resume.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.resume.entities.UserDtls;
import com.resume.helper.Message;
import com.resume.repository.UserRepo;
import com.resume.service.Service;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/admin")
public class Admincontroller {
	@Autowired
	private Service service;
	@Autowired
	private UserRepo userrepo;
	
	static int ID;


	@PostMapping("/register")
	public String usersRegister(@ModelAttribute UserDtls e,Principal principal,Model m) {
	
	
		UserDtls user= userrepo.getById(ID);
	
		user.setName(e.getName());
	
		System.out.println(user);
		
		userrepo.save(user);
		List<UserDtls> users=service.getusers();
		m.addAttribute("users",users);
		return "deleteusers";
	}
	
	@GetMapping("/deleteusers")
	public String deleteusers(Model m) {
			List<UserDtls> users=service.getusers();
			m.addAttribute("users",users);
		return "deleteusers";
	}
	
//show contacts
@GetMapping("/showusers")
public String show(Model m) {
		List<UserDtls> users=service.getusers();
		m.addAttribute("users",users);
	return "normal/showusers";
}


@GetMapping("/dashboard")
public String dashboard(Model m) {
		
	return "normal/dashboard";
}





@GetMapping("/adminprofile")
public String adminprofile(@ModelAttribute UserDtls u,Principal principal,Model model) {
	String name =principal.getName();
	UserDtls emp=userrepo.getUserByUserName(name);
	model.addAttribute("emp",emp);	
	
		return "normal/adminprofile";
}





@GetMapping("/about")
public String about(Model m) {
		
	return "normal/about";
}


@GetMapping("/edit/{id}")
public String postEdit(@PathVariable("id") int id ,Model m,Principal principal) {
	ID=id;
	
	UserDtls emp=service.getuserByid(id);
	m.addAttribute("emp",emp);
	return "edit";
	
}
@GetMapping("/delete/{id}")
public String delete(@PathVariable("id") int id ,Model m,Principal principal) {
	userrepo.deleteById(id);
	List<UserDtls> users=service.getusers();
	m.addAttribute("users",users);	
	return "deleteusers";
	
}


}
