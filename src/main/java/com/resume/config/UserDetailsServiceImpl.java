package com.resume.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.resume.entities.UserDtls;
import com.resume.repository.UserRepo;



public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired 
	private UserRepo userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDtls user=userRepository.getUserByUserName(username);
		if(user==null) {
			throw new UsernameNotFoundException("Could Not Found User !");
		}
		CustomUserDetails customUserDetails= new CustomUserDetails(user);
		return customUserDetails;
	}

}
