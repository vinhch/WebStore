package com.vinhomn.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vinhomn.data.domain.Authority;
import com.vinhomn.data.domain.User;
import com.vinhomn.data.repository.UserRepository;

@Service("customSSUserDetailsService")
@Transactional
public class CustomSSUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			User user = userRepository.findOneByUsername(username);

			if (user == null)
				user = userRepository.findOneByEmail(username);
			
			if (user != null)
				return new org.springframework.security.core.userdetails.User(user.getUsername(),
						user.getPassword(),
						getAuthorities(user));

			return null;
		} catch (Exception e) {
			throw new UsernameNotFoundException("User not found");
		}
	}

	private Set<GrantedAuthority> getAuthorities(User user) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		
		for (Authority authority : user.getAuthorities()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getCode());
			authorities.add(grantedAuthority);
		}
		
		return authorities;
	}

}
