package com.Backend.REST.service;

import java.util.*;
import java.util.stream.Collectors;

import com.Backend.REST.DTO.TaskRequestDTO;
import com.Backend.REST.DTO.TaskResponseDTO;
import com.Backend.REST.exception.TaskNotFoundException;
import com.Backend.REST.mapper.TaskMapper;
import com.Backend.REST.repository.TaskRepository;
import com.Backend.REST.entity.Task;

import com.Backend.REST.types.Priority;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    // createTask(Task task): Tell repository to save a new task, return it
    @Transactional(readOnly = true)
    public TaskResponseDTO createTask(TaskRequestDTO taskDTO){
        Task taskEntity = TaskMapper.toEntity(taskDTO);
        return TaskMapper.toResponseDTO(taskRepository.save(taskEntity));
    }

    // getAllTasks(): Ask repository for all tasks, return them
    @Transactional(readOnly = true)
    public Page<TaskResponseDTO> getAllTasks(Pageable pageable){
        return taskRepository.findAll(pageable)
                .map(task -> TaskMapper.toResponseDTO(task));
    }

    // getTaskById(Long id): Ask repository for one task by id, return it
    @Transactional(readOnly = true)
    public TaskResponseDTO getTaskById(Long id){
        return TaskMapper.toResponseDTO(taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found")));
    }

    //deleteByID
    @Transactional
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    // updateTask(Long id, Task task) : Find e                                                                                                               xisting task, update its fields, save it
    @Transactional
    public TaskResponseDTO updateTask(Long id, TaskRequestDTO task){
        Task thisTask = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(
                "Task not found"));
        thisTask.setTitle(task.getTitle());
        thisTask.setDescription(task.getDescription());
        thisTask.setIsCompleted(task.getIsCompleted());
        return TaskMapper.toResponseDTO(thisTask);
    }

    // markAsComplete(Long id): Find task, set isCompleted to true, save it
    @Transactional
    public TaskResponseDTO markAsComplete(Long id){
        Task thisTask = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        thisTask.setIsCompleted(true);
        return TaskMapper.toResponseDTO(thisTask); //cross-check later
    }

    public Page<TaskResponseDTO> searchTaskByTitle(String title, Pageable pageable){
        return taskRepository.findByTitleContainingIgnoreCase(title, pageable).map(TaskMapper::toResponseDTO);
    }
    public Page<TaskResponseDTO> getTaskByPriority(Priority priority, Pageable pageable){
        return taskRepository.findByPriority(priority, pageable).map(TaskMapper::toResponseDTO);
    }
    public Page<TaskResponseDTO> getTaskByStatus(Boolean isCompleted, Pageable pageable){
        return taskRepository.findByIsCompleted(isCompleted, pageable).map(TaskMapper::toResponseDTO);
    }


}





