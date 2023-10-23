package com.devworks.sbootask.repositories;

import com.devworks.sbootask.dtos.TaskRequestDTO;
import com.devworks.sbootask.entities.TaskEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {

    private final List<TaskEntity> taskEntities = new ArrayList<>();

    public TaskEntity getTask(Integer id) {
        return taskEntities.stream().filter(task -> task.getId().equals(id)).findFirst().get();
    }

    public List<TaskEntity> getAllTasks() {
        return new ArrayList<>(taskEntities);
    }

    public TaskEntity createTask(TaskRequestDTO taskRequestDTO) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(taskEntities.isEmpty() ? 1 : taskEntities
                .stream()
                .map(TaskEntity::getId)
                .max((id1, id2) -> id1 > id2 ? id1 : id2).get());
        taskEntity.setContent(taskRequestDTO.getContent());
        taskEntities.add(taskEntity);
        return taskEntity;
    }

}
