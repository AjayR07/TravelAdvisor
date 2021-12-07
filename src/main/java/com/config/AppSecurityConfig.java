package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	AuthenticationSuccessHandler authenticationSuccessHandler;
	// in order to say we dont need spring default page 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin").hasRole("admin")

		.and()
			.formLogin().loginPage("/login").successHandler(authenticationSuccessHandler)
			.defaultSuccessUrl("/products/all")
			.failureUrl("/login?error")
			.usernameParameter("username").passwordParameter("password")
			.and()
			.logout().invalidateHttpSession(true)
		    .clearAuthentication(true)
		    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		    .logoutSuccessUrl("/").permitAll();
	     
	}

	@Autowired
	private UserDetailsService userDetailsService; 
	
	@Bean
	public AuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		 System.out.println("ss");
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder(8));
		return provider;
		
	}
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService()
//	{
//		List<UserDetails> users =  new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder().username("keerthi").password("1234").roles("USER").build());
//		return new InMemoryUserDetailsManager(users);
//	}
}