package com.github.hamilton.ssecurity.simple;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class DummyUser implements UserDetails{

	private static final long serialVersionUID = 1L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(() -> "READ");
	}

	@Override
	public String getPassword() {
		return "thelastofus";
	}

	@Override
	public String getUsername() {
		return "joel";
	}
	
	

}
