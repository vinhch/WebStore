package com.vinhomn.service;

import java.util.List;

import com.vinhomn.data.domain.User;

public interface UserService {
    public String encodePassword(String password);
    public User save(User entity);
    public User encodePasswordAndSave(User entity);
    public void delete(long id);
    public User findOne(long id);
    public User findOneByUsername(String username);
    public User findOneByEmail(String email);
    public List<User> findAll();
    public User createNewUserAccount(User entity) throws Exception;
}
