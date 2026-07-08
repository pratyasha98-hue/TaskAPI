package com.Backend.REST.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserResponseDTO {
    private long uid;
    private String name;
    private int age;
    private String emailAddr;
    private LocalDateTime createdAt;

}
