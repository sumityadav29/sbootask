package com.devworks.sbootask.controllers;

import com.devworks.sbootask.dtos.TaskRequestDTO;
import com.devworks.sbootask.dtos.TaskResponseDTO;
import com.devworks.sbootask.entities.TaskEntity;
import com.devworks.sbootask.repositories.TaskRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskResponseDTO> getTask(@PathVariable Integer id) {
        TaskEntity taskEntity = taskRepository.getTask(id);
        TaskResponseDTO taskResponseDTO = new TaskResponseDTO(taskEntity.getId(), taskEntity.getContent());
        return ResponseEntity.ok(taskResponseDTO);
    }

    @GetMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskResponseDTO>> getTasks() {
        List<TaskEntity> taskEntities = taskRepository.getAllTasks();
        List<TaskResponseDTO> taskResponseDTOS = taskEntities.stream()
                .map(taskEntity -> new TaskResponseDTO(taskEntity.getId(), taskEntity.getContent()))
                .toList();
        return ResponseEntity.ok(taskResponseDTOS);
    }

    @PostMapping("/tasks")
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO taskRequestDTO) {
        TaskEntity taskEntity = taskRepository.createTask(taskRequestDTO);
        TaskResponseDTO taskResponseDTO = new TaskResponseDTO(taskEntity.getId(), taskEntity.getContent());
        return ResponseEntity.ok(taskResponseDTO);
    }

}
