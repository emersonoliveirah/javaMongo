package com.javaMongo.infraestructure.repository;

import com.javaMongo.infraestructure.entity.AddressEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AddressRepository extends MongoRepository<AddressEntity, String> {

        AddressEntity findByUserId(String userId);

        @Transactional
        void deleteByUserId(String userId);
}
