package com.Backend.REST.service;


import com.Backend.REST.DTO.UserRequestDTO;
import com.Backend.REST.DTO.UserResponseDTO;
import com.Backend.REST.entity.User;
import com.Backend.REST.exception.UserNotFoundException;
import com.Backend.REST.mapper.UserMapper;
import com.Backend.REST.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDTO createUser(UserRequestDTO requestDTO){
        if (userRepository.existsByEmail(requestDTO.getEmail())) {
            throw new IllegalArgumentException("Email is already registered!");
        }
        User newUser = UserMapper.toUserEntity(requestDTO);
        return UserMapper.toUserResponseDTO(userRepository.save(newUser));
    }

    @Transactional(readOnly = true)
    public Page<UserResponseDTO> getAllUsers(Pageable pageable){
        return userRepository.findAll(pageable).map(UserMapper :: toUserResponseDTO);
    }

    @Transactional(readOnly = true)
    public UserResponseDTO getUserById(Long uid){
        return UserMapper.toUserResponseDTO(userRepository.findById(uid).orElseThrow(()->
                new UserNotFoundException("User not found")));
    }

    @Transactional
    public UserResponseDTO updateUser(Long uid, UserRequestDTO requestDTO){
            User userEntity = userRepository.findById(uid).orElseThrow(() -> new UserNotFoundException("User not found"));
            userEntity.setName(requestDTO.getName());
            userEntity.setAge(requestDTO.getAge());
            userEntity.setEmail(requestDTO.getEmail());
            return UserMapper.toUserResponseDTO(userEntity);
    }

    @Transactional
    public void deleteUser(Long uid){
        if (!userRepository.existsById(uid)) {
            throw new UserNotFoundException("User not found with id: " + uid);
        }
        userRepository.deleteById(uid);
    }

    @Transactional(readOnly = true)
    public UserResponseDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));
        return UserMapper.toUserResponseDTO(user);
    }

}
