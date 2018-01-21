package com.code4life.ecommerce.service;

import com.code4life.ecommerce.model.User;

public interface UserService {
    User saveUser(User user);

    void deleteUser(Long id);

    Iterable<User> getAllUsers();
}

