package com.code4life.ecommerce.service.impl;

import com.code4life.ecommerce.model.User;
import com.code4life.ecommerce.repositories.UserRepository;
import com.code4life.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    public List<User> getAllUsers() {
        return (userRepository.findAll());
    }


}
