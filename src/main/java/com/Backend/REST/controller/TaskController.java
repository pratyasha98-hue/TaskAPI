package com.Backend.REST.controller;


import com.Backend.REST.DTO.TaskRequestDTO;
import com.Backend.REST.DTO.TaskResponseDTO;
import com.Backend.REST.entity.Task;
import com.Backend.REST.service.TaskService;
import com.Backend.REST.types.Priority;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.model.ast.builder.TableDeleteBuilderSkipped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tasks")
public class TaskController {


    private final TaskService taskService;

    @GetMapping
    public Page<TaskResponseDTO> getAllTasks(@RequestParam(required = false) Boolean isCompleted,
                                               @RequestParam(required = false) Priority priority,
                                               @RequestParam(required = false, defaultValue = "0") int pageNo,
                                               @RequestParam(required = false, defaultValue = "5") int pageSize){
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        if(isCompleted == null){
            return taskService.getTaskByPriority( priority, pageable);
        }
        else if(priority == null){
            return taskService.getTaskByStatus(isCompleted, pageable);
        }
        return taskService.getAllTasks(pageable);
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

    @GetMapping("/search")
    public Page<TaskResponseDTO> searchByTitle(@RequestParam(required = true) String title,
                                               @RequestParam(defaultValue = "0") int pageNo,
                                               @RequestParam(defaultValue = "5") int pageSize){
        return taskService.searchTaskByTitle(title, PageRequest.of(pageNo, pageSize));
    }



}
