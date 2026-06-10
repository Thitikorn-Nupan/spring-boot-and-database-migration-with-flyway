package com.ttknp.understandflyway.dto;

import com.ttknp.understandflyway.entities.User;
import com.ttknp.understandflyway.repositories.UserRepository;
import com.ttknp.understandflyway.services.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserDTOCommonService implements CommonService<User> {

    private final UserRepository userRepository;

    @Autowired
    public UserDTOCommonService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> retrieveAllModels() {
        return userRepository.findAll();
    }

    @Override
    public <U> Optional<User> retrieveModel(U key) {
        return Optional.empty();
    }

    @Override
    public Boolean createModel(User model) {
        return null;
    }

    @Override
    public <U> Boolean updateModel(User model, U key) {
        return null;
    }

    @Override
    public <U> Boolean deleteModel(U key) {
        return null;
    }


}
