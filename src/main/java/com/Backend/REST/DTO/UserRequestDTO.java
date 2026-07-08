package com.Backend.REST.DTO;

import com.Backend.REST.types.Priority;
import com.Backend.REST.types.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

        @NotBlank(message = "Name cannot be empty")
        @Size(min=3, max= 100, message = "Name should be between 3 to 100 characters")
        private String name;

        @Min(value = 18, message = "Age must be at least 18")
        private Integer age;

        @NotBlank(message = "Password cannot be blank")
        @Size(min = 6, message = "Password must be at least 6 characters long")
        private String password;

        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Invalid email format")
        private String email;

        @NotNull(message = "Role is required")
        private Role role;

}

