package com.vinhomn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.vinhomn.service.CustomSSUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomSSUserDetailsService userDetailsService;
	
	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return userDetailsService;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			    .antMatchers("/admin/**").hasAuthority("ADMIN")
			    .anyRequest().permitAll()
			    .and()
			.formLogin()
			    .loginPage("/admin/signin")
			    .permitAll()
			    .and()
			.logout()
			    .permitAll();
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        /*auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");*/
		
		auth.userDetailsService(userDetailsServiceBean());
    }
}
