package com.Backend.REST.DTO;

import com.Backend.REST.types.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private Long uid;
    private String name;
    private Integer age;
    private String email;
    private Role role;
    private LocalDateTime createdAt;



}
