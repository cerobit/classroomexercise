package com.example.ClassRoom.repository;

import com.example.ClassRoom.model.ClassRoom;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClassRoomRepository extends ReactiveMongoRepository<ClassRoom, String>{

}

