package com.ttknp.understandflyway.controller;

import com.ttknp.understandflyway.entities.Product;
import com.ttknp.understandflyway.entities.User;
import com.ttknp.understandflyway.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserControl {
    private final UserService userService;

    @Autowired
    public UserControl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/reads")
    public ResponseEntity<Iterable<User>> reads() {
        return ResponseEntity.ok(userService.retrieveAllUsers());
    }

}
