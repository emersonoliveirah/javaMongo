package com.javaMongo.api.converter;

import com.javaMongo.api.response.UserResponseDTO;
import com.javaMongo.infraestructure.entity.AddressEntity;
import com.javaMongo.infraestructure.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id" , source = "userEntity.id")
    @Mapping(target = "name" , source = "userEntity.name")
    @Mapping(target = "email" , source = "userEntity.email")
    @Mapping(target = "document" , source = "userEntity.document")
    @Mapping(target = "address" , source = "addressEntity")
    UserResponseDTO toUserResponseDTO(UserEntity userEntity, AddressEntity addressEntity);
}
