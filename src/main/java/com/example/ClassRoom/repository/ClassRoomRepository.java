package com.example.ClassRoom.repository;

import com.example.ClassRoom.model.ClassRoom;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ClassRoomRepository extends ReactiveMongoRepository<ClassRoom, String>{
    // Todo study This https://lishman.io/spring-data-mongodb-repository-queries
    @Query("{'name':?0}")
    Flux<ClassRoom> findByName(final String name);
}

