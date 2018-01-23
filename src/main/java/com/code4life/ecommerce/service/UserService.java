package com.code4life.ecommerce.service;

import com.code4life.ecommerce.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    void deleteUser(Long id);

    List<User> getAllUsers();
}

