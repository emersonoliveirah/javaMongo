package com.javaMongo.business;

import com.javaMongo.api.converter.UserConverter;
import com.javaMongo.api.converter.UserMapper;
import com.javaMongo.api.request.UserRequestDTO;
import com.javaMongo.api.response.UserResponseDTO;
import com.javaMongo.infraestructure.entity.AddressEntity;
import com.javaMongo.infraestructure.entity.UserEntity;
import com.javaMongo.infraestructure.exceptions.BusinessException;
import com.javaMongo.infraestructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.util.Assert.notNull;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final UserMapper userMapper;
    private final AddressService addressService;

    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public UserResponseDTO recordUser(UserRequestDTO userRequestDTO) {
        try {
            notNull(userRequestDTO, "UserRequestDTO cannot be null");
            UserEntity userEntity = saveUser(userConverter.toUserEntity(userRequestDTO));
            AddressEntity addressEntity = addressService.saveAddress(userConverter.toAddressEntity(userRequestDTO.getAddress(), userEntity.getId()));
            return userMapper.toUserResponseDTO(userEntity, addressEntity);
        } catch (Exception e) {
            throw new BusinessException("Error saving user", e);
        }
    }

    public UserResponseDTO getUser(String email) {
        try {
            UserEntity userEntity = userRepository.findByEmail(email);
            notNull(userEntity, "User not found");
            AddressEntity addressEntity = addressService.findByUserId(userEntity.getId());

            return userMapper.toUserResponseDTO(userEntity, addressEntity);
        } catch (Exception e) {
            throw new BusinessException("Error in searching user data", e);
        }

    }

    @Transactional
    public void deleteUser(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        UserRepository.deleteByEmail(email);
        addressService.deleteByUserId(userEntity.getId());
    }
}
