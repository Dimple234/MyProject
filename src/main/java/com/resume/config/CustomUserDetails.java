package com.resume.config;


import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.resume.entities.UserDtls;



public class CustomUserDetails implements UserDetails{

	private UserDtls user;
	
	
	public CustomUserDetails(UserDtls user) {
		
		super();
		System.out.println("-------"+user);
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getRole());
		System.out.println("SimpleGrantedAuothority:"+simpleGrantedAuthority);
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		System.out.println("Password"+user.getPassword());
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
