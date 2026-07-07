package com.Backend.REST.mapper;

import com.Backend.REST.DTO.TaskRequestDTO;
import com.Backend.REST.DTO.TaskResponseDTO;
import com.Backend.REST.entity.Task;
import com.Backend.REST.types.Priority;

public class TaskMapper {

    //DTO -> Entity
    public static Task toEntity(TaskRequestDTO requestDTO){
        Task taskEntity = new Task();
        taskEntity.setDescription(requestDTO.getDescription());
        taskEntity.setTitle(requestDTO.getTitle());
        taskEntity.setIsCompleted(requestDTO.getIsCompleted());
        taskEntity.setPriority(requestDTO.getPriority());
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
        newDTO.setPriority(task.getPriority());
        return newDTO;
    }
}
