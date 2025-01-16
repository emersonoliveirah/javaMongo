package com.javaMongo.infraestructure.repository;

import com.javaMongo.infraestructure.entity.AddressEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<AddressEntity, String> {
}
