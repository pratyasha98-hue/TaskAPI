package com.Backend.REST.mapper;

import com.Backend.REST.DTO.UserRequestDTO;
import com.Backend.REST.DTO.UserResponseDTO;
import com.Backend.REST.entity.User;

public class UserMapper {
    //DTO -> Entity
    public  static User toUserEntity(UserRequestDTO requestDTO){
        User userEntity = new User();
        userEntity.setName(requestDTO.getName());
        userEntity.setAge(requestDTO.getAge());
        userEntity.setPassword(requestDTO.getPassword());
        userEntity.setEmail(requestDTO.getEmail());
        userEntity.setRole(requestDTO.getRole());
        return userEntity;
    }
    //Entity -> DTO
    public static UserResponseDTO toUserResponseDTO(User userEntity){
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setUid(userEntity.getUid());
        responseDTO.setName(userEntity.getName());
        responseDTO.setRole(userEntity.getRole());
        responseDTO.setAge(userEntity.getAge());
        responseDTO.setEmail(userEntity.getEmail());
        responseDTO.setCreatedAt(userEntity.getCreatedAt());
        return responseDTO;
    }
}
