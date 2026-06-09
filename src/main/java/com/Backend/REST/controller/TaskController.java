package com.Backend.REST.controller;


import com.Backend.REST.DTO.TaskRequestDTO;
import com.Backend.REST.DTO.TaskResponseDTO;
import com.Backend.REST.entity.Task;
import com.Backend.REST.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<TaskResponseDTO> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskResponseDTO getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    //createTask() → @PostMapping + @RequestBody
    @PostMapping
    public TaskResponseDTO createTask(@Valid @RequestBody  TaskRequestDTO task){
        return taskService.createTask(task);
    }

    // updateTask()
    @PutMapping("/{id}")
    public TaskResponseDTO updateTask(@PathVariable Long id, @Valid @RequestBody  TaskRequestDTO task){
        return taskService.updateTask(id, task);
    }

    //⏳ deleteTask()
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

    //⏳ markAsComplete()
    @PatchMapping("/{id}/complete")
    public TaskResponseDTO markAsComplete(@PathVariable Long id){
        return taskService.markAsComplete(id);
    }

}
