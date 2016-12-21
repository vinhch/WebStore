package com.vinhomn.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinhomn.data.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public User findById(long id);
	public User findByUsername(String username);
	public User findByEmail(String email);
}
