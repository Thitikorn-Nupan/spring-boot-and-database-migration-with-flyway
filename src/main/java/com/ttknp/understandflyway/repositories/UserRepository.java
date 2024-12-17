package com.ttknp.understandflyway.repositories;

import com.ttknp.understandflyway.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> { }
