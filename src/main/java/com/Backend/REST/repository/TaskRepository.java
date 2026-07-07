package com.Backend.REST.repository;


import com.Backend.REST.entity.Task;
import com.Backend.REST.types.Priority;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
        Page<Task> findByIsCompleted(Boolean isCompleted, Pageable pageable);
        Page<Task> findByTitleContainingIgnoreCase(String title, Pageable pageable);
        Page<Task> findByPriority(Priority priority, Pageable pageable);

}
