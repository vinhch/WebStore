package com.vinhomn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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
				.antMatchers("/admin/signup")
					.access("hasIpAddress('127.0.0.1/32') or hasIpAddress('0:0:0:0:0:0:0:1/128')")
			    .antMatchers("/admin/**").hasAuthority("ADMIN")
			    .anyRequest().permitAll()
			    .and()
			.formLogin()
			    .loginPage("/admin/signin")
			    .defaultSuccessUrl("/")
			    .permitAll()
			    .and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
				.logoutSuccessUrl("/")
			    .permitAll()
			    .and()
	            .requestCache();
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        /*auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");*/
		
		auth.userDetailsService(userDetailsServiceBean())
			.passwordEncoder(passwordencoder());
    }
	
	@Bean(name = "passwordEncoder")
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
}
