package com.devworks.sbootask.dtos;

import lombok.Data;

@Data
public class TaskResponseDTO {
    private Integer id;
    private String content;

    public TaskResponseDTO(Integer id, String content) {
        this.id = id;
        this.content = content;
    }
}
