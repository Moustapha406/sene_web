package com.sene.repository;

import com.sene.entities.User;

public interface UserRepository {
    public User addUser(User user);
    public User login(String username,String password);
}
