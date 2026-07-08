package com.Backend.REST.DTO;

import com.Backend.REST.types.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
        @NotBlank
        private long uid;
        @NotBlank
        private String email;

}

