package com.vinhomn.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinhomn.data.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findOneByUsername(String username);
    public User findOneByEmail(String email);
}
