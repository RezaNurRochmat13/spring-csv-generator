package com.spring.generator.CSV.service;

import com.spring.generator.CSV.entity.User;

import java.util.List;

public interface UserService {
    List<User> doGetAllUsers();
}
