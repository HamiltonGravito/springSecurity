package com.github.hamilton.ssecurity.simple;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class ImmutableInstance {

	UserDetails userDetails = User.withUsername("joel")
			.password("thelastofus")
			.authorities("WRITE", "READ")
			.accountExpired(false)
			.disabled(true)
			.build();
	
	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	User.UserBuilder builder = User.withUsername("elli");
	UserDetails userDetails2 = builder
			.password("thelastofus")
			.authorities("READ")
			.passwordEncoder(passwordEncoder::encode)
			.accountExpired(false)
			.disabled(true)
			.build();
}
