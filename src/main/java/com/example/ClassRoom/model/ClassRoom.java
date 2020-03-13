package com.example.ClassRoom.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder

public class ClassRoom {

    @Id
    private String id;

    private String name, block, level;
    private int capacity, leftHours;

}
