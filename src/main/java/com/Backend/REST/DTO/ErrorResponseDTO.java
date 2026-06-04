package com.Backend.REST.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDTO {

    int status;
    String message;
    LocalDateTime timestamp;

}
