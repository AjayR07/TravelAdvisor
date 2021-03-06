//package com.util;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//@Configuration
//@EnableWebSecurity
//public class LoginSecurityConfigurer extends WebSecurityConfigurerAdapter{
//	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr)throws Exception {
//		//CREDENTIALS...
//		authenticationMgr.inMemoryAuthentication().withUser("presedio").password("{noop}secret").authorities("ROLE_USER");
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/homePage").access("hasRole('ROLE_USER')")
//		.and()
//			.formLogin().loginPage("/loginPage")
//			.defaultSuccessUrl("/products/all")
//			.failureUrl("/loginPage?error")
//			.usernameParameter("username").passwordParameter("password")
//			.and().logout().logoutSuccessUrl("/loginPage?logout");
//	}
//}