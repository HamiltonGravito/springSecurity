package com.github.hamilton.ssecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.github.hamilton.ssecurity.auth.CustomAuthenticationProvider;

@Configuration
public class ProjectConfig {

	private final CustomAuthenticationProvider authenticationProvider;
	
	public ProjectConfig(CustomAuthenticationProvider authenticationProvider) {
		this.authenticationProvider = authenticationProvider;
	}
	
	// Configuração Personalizada
	@Bean
	SecurityFilterChain configure(HttpSecurity http) 
			throws Exception {
		http.httpBasic(Customizer.withDefaults());
		http.authenticationProvider(authenticationProvider);
		http.authorizeHttpRequests(
				c -> c.anyRequest().authenticated());
		return http.build();
	}
	
	/*@Bean
	SecurityFilterChain configure(HttpSecurity http) 
		throws Exception {
		
		//Autenticação Básica
		http.httpBasic(Customizer.withDefaults()); 
		
		//Todas as solicitações exigem autenticação (.permitAll() é o reverso)
		http.authorizeHttpRequests(
			c -> c.anyRequest().authenticated()); 
		
		var user1 = User
				.withUsername("user1")
				.password("{noop}password1")
				.authorities("read")
				.build();
		var userDetailsService = new InMemoryUserDetailsManager(user1);
		http.userDetailsService(userDetailsService);
		
		return http.build();
	}*/

	/*@Bean
	UserDetailsService userDetailsService() {
		var user = User
				.withUsername("user")
				.password("{noop}password")
				.authorities("read")
				.build();
		return new InMemoryUserDetailsManager(user);
	}*/
}
