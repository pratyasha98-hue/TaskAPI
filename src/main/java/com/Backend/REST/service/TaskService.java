package com.Backend.REST.service;

import java.util.*;
import java.util.stream.Collectors;

import com.Backend.REST.DTO.TaskRequestDTO;
import com.Backend.REST.DTO.TaskResponseDTO;
import com.Backend.REST.mapper.TaskMapper;
import com.Backend.REST.repository.TaskRepository;
import com.Backend.REST.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // createTask(Task task): Tell repository to save a new task, return it
    public TaskResponseDTO createTask(TaskRequestDTO taskDTO){
        Task taskEntity = TaskMapper.toEntity(taskDTO);
        return TaskMapper.toResponseDTO(taskRepository.save(taskEntity));
    }

    // getAllTasks(): Ask repository for all tasks, return them
    public List<TaskResponseDTO> getAllTasks(){
        return taskRepository.findAll().stream()
                .map(task -> TaskMapper.toResponseDTO(task))
                .collect(Collectors.toList());
    }

    // getTaskById(Long id): Ask repository for one task by id, return it
    public TaskResponseDTO getTaskById(Long id){
        return TaskMapper.toResponseDTO(taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found")));
    }

    //deleteByID
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    // updateTask(Long id, Task task) : Find e                                                                                                               xisting task, update its fields, save it
    public TaskResponseDTO updateTask(Long id, TaskRequestDTO task){
        Task thisTask = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        thisTask.setTitle(task.getTitle());
        thisTask.setDescription(task.getDescription());
        thisTask.setIsCompleted(task.getIsCompleted());
        return TaskMapper.toResponseDTO(taskRepository.save(thisTask));
    }

    // markAsComplete(Long id): Find task, set isCompleted to true, save it
    public TaskResponseDTO markAsComplete(Long id){
        Task thisTask = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        thisTask.setIsCompleted(true);
        return TaskMapper.toResponseDTO(taskRepository.save(thisTask));
    }
}





