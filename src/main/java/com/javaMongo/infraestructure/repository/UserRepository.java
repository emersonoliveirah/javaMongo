package com.javaMongo.infraestructure.repository;

import com.javaMongo.infraestructure.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends MongoRepository<UserEntity, String> {

    UserEntity findByEmail(String email);

    @Transactional
    static void deleteByEmail(String email) {
    }
}
