package com.vinhomn.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vinhomn.data.domain.User;
import com.vinhomn.data.repository.UserRepository;
import com.vinhomn.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}

	@Override
	public User save(User entity) {
		return userRepository.save(entity);
	}
	
	@Override
	public User encodePasswordAndSave(User entity) {
		entity.setPassword(this.encodePassword(entity.getPassword()));
		return this.save(entity);
	}

	@Override
	public void delete(long id) {
		userRepository.delete(id);
	}

	@Override
	public User findOne(long id) {
		return userRepository.findOne(id);
	}

	@Override
	public User findOneByUsername(String username) {
		return userRepository.findOneByUsername(username);
	}

	@Override
	public User findOneByEmail(String email) {
		return userRepository.findOneByEmail(email);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User createNewUserAccount(User entity) throws Exception {
		User user = userRepository.findOneByUsername(entity.getUsername());
		if (user != null) 
			throw new Exception("Already has an user with name " + entity.getUsername());
		
		user = userRepository.findOneByEmail(entity.getEmail());
		if (user != null) 
			throw new Exception("Already has an user with email " + entity.getEmail());
		
		entity.setEnabled(true);
		return this.encodePasswordAndSave(entity);
	}

}
