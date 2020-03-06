package com.example.ClassRoom.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
public class ClassRoom {

    @Id
    private String id;

    private String name, block, level;
    private int capacity, leftHours;

}
