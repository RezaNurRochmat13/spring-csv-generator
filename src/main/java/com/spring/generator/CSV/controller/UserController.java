package com.spring.generator.CSV.controller;

import com.spring.generator.CSV.entity.User;
import com.spring.generator.CSV.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

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
    public ResponseEntity<Object> createUsers(@Valid @RequestBody User payload) {
        return new ResponseEntity<>(userService.doCreateUsers(payload), HttpStatus.CREATED);
    }

    @GetMapping("/users/report/generate")
    public ResponseEntity<Object> generateReportUser(HttpServletResponse httpServletResponse)
            throws IOException {
        httpServletResponse.setContentType("text/csv");
        httpServletResponse.addHeader("Content-Disposition","attachment; filename=\"untitled.csv\"");
        return new ResponseEntity<>("Success generated report", HttpStatus.OK);
    }
}
