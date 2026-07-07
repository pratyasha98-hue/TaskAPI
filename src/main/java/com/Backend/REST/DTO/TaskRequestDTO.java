package com.Backend.REST.DTO;

import com.Backend.REST.types.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequestDTO {

    @NotBlank(message = "Title cannot be empty")
    @Size(min=3, max= 100, message = "Title should be between 3 to 100 characters")
    private String title;
    @NotBlank
    private String description;
    private Boolean isCompleted;
    private Priority priority;
}
