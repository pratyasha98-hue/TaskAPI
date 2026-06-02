package com.Backend.REST.mapper;

import com.Backend.REST.DTO.TaskRequestDTO;
import com.Backend.REST.DTO.TaskResponseDTO;
import com.Backend.REST.entity.Task;

public class TaskMapper {

    //DTO -> Entity
    public static Task toEntity(TaskRequestDTO requestDTO){
        Task taskEntity = new Task();
        taskEntity.setDescription(requestDTO.getDescription());
        taskEntity.setTitle(requestDTO.getTitle());
        taskEntity.setIsCompleted(requestDTO.getIsCompleted());
        return taskEntity;
    }

    // Entity -> DTO
    public static TaskResponseDTO toResponseDTO(Task task){
        TaskResponseDTO newDTO = new TaskResponseDTO();
        newDTO.setId(task.getId());
        newDTO.setCreatedAt(task.getCreatedAt());
        newDTO.setTitle(task.getTitle());
        newDTO.setDescription(task.getDescription());
        newDTO.setIsCompleted(task.getIsCompleted());
        return newDTO;
    }
}
