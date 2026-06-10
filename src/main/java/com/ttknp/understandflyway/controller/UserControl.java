package com.ttknp.understandflyway.controller;

import com.ttknp.understandflyway.entities.User;
import com.ttknp.understandflyway.services.UserService;
import com.ttknp.understandflyway.services.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserControl {

    private final UserService userService;
    private final CommonService<User> commonService;

    @Autowired
    public UserControl(UserService userService, CommonService<User> commonService) {
        this.userService = userService;
        this.commonService = commonService;
    }

    @GetMapping(value = "/reads")
    public ResponseEntity<Iterable<User>> reads() {
        return ResponseEntity.ok(userService.retrieveAllUsers());
    }

    @GetMapping(value = "/common/reads")
    public ResponseEntity<Iterable<User>> commonReads() {
        return ResponseEntity.ok(commonService.retrieveAllModels());
    }

}
