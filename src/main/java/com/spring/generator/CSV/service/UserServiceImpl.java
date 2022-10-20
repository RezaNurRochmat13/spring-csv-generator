package com.spring.generator.CSV.service;

import com.spring.generator.CSV.entity.User;
import com.spring.generator.CSV.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> doGetAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User doCreateUsers(User payload) {
        return userRepository.save(payload);
    }
}
