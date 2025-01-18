package com.javaMongo.api.converter;

import com.javaMongo.api.request.AddressRequestDTO;
import com.javaMongo.api.request.UserRequestDTO;
import com.javaMongo.infraestructure.entity.AddressEntity;
import com.javaMongo.infraestructure.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserConverter {

    public UserEntity toUserEntity(UserRequestDTO userDTO) {
        return UserEntity.builder()
                .id(UUID.randomUUID().toString())
                .name(userDTO.getName())
                .document(userDTO.getDocument())
                .email(userDTO.getEmail())
                .createdAt(LocalDateTime.now())
                .build();
}

    public AddressEntity toAddressEntity(AddressRequestDTO addressDTO, String userId) {
        return AddressEntity.builder()
                .street(addressDTO.getStreet())
                .number(Long.valueOf(addressDTO.getNumber()))
                .userId(userId)
                .locality(addressDTO.getLocality())
                .city(addressDTO.getCity())
                .complement(addressDTO.getComplement())
                .zipCode(addressDTO.getZipCode())
                .build();
    }
}
