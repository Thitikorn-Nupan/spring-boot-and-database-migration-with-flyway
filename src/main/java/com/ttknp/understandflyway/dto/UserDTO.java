package com.ttknp.understandflyway.dto;

import com.ttknp.understandflyway.entities.User;
import com.ttknp.understandflyway.repositories.UserRepository;
import com.ttknp.understandflyway.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDTO implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserDTO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> retrieveAllUsers() {
        return userRepository.findAll();
    }
}
