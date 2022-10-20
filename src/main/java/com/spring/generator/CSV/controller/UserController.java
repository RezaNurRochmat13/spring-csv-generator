package com.spring.generator.CSV.controller;

import com.spring.generator.CSV.entity.User;
import com.spring.generator.CSV.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
@Slf4j
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers() {
        return new ResponseEntity<>(userService.doGetAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUsers(@RequestBody User payload) {
        return new ResponseEntity<>(userService.doCreateUsers(payload), HttpStatus.CREATED);
    }
}
