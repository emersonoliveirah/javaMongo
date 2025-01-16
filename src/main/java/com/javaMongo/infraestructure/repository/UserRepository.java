package com.javaMongo.infraestructure.repository;

import com.javaMongo.infraestructure.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, String> {
}
