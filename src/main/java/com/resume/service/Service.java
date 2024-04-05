package com.resume.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.resume.entities.UserDtls;
import com.resume.repository.UserRepo;

@org.springframework.stereotype.Service
public class Service {
	@Autowired
	private UserRepo userrepo;


	
	public void adduser(UserDtls  e) {
		userrepo.save(e);
	}
	public List<UserDtls> getusers(){
		return userrepo.findAll();
	}
	public UserDtls getuserByid(int id) {
		Optional<UserDtls> e = userrepo.findById(id);
		if (e.isPresent()) {
			return e.get();
		}
		return null;
	}
	
	
}
