package com.Backend.REST.exception;

import com.Backend.REST.DTO.ErrorResponseDTO;
import com.Backend.REST.DTO.TaskResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> taskNotFoundHandler(TaskNotFoundException ex){
        ErrorResponseDTO error = new ErrorResponseDTO(404, ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorResponseDTO>(error, HttpStatus.NOT_FOUND);
    }

}
