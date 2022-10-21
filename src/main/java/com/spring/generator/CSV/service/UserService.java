package com.spring.generator.CSV.service;

import com.spring.generator.CSV.entity.User;

import java.io.Writer;
import java.util.List;

public interface UserService {
    List<User> doGetAllUsers();
    User doCreateUsers(User payload);

    void doGenerateReportUser(Writer writer) throws Exception;
}
