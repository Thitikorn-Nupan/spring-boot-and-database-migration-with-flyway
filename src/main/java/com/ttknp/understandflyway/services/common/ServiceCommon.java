package com.ttknp.understandflyway.services.common;


import com.ttknp.understandflyway.entities.User;

import java.util.Optional;

public interface ServiceCommon <T> {
    Iterable<T> retrieveAllModels();
    <U> Optional<T> retrieveModel(U key);
    Boolean createModel(T model);
    <U> Boolean updateModel(T model, U key);
    <U> Boolean deleteModel(U key);
}
