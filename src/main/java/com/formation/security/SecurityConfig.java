package com.formation.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/humancontact/**").authenticated().antMatchers("/humancontact/home/**")
				.permitAll().antMatchers("/humancontact/admin/**").hasAnyRole("ADMIN")
				.antMatchers("/humancontact/user/**").hasAnyRole("USER").and().formLogin().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/humancontact/admin/logout"));

	}

	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserBuilder builder = User.withDefaultPasswordEncoder();
		UserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
		userDetailsManager.createUser(builder.username("admin").password("admin").roles("ADMIN", "USER").build());
		userDetailsManager.createUser(builder.username("user").password("user").roles("USER").build());
		return userDetailsManager;
	}

}
