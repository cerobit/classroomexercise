package com.example.ClassRoom.controller;


import com.example.ClassRoom.model.ClassRoom;
import com.example.ClassRoom.repository.ClassRoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/classroom")
@AllArgsConstructor
public class ClassRoomController {

    private ClassRoomRepository repository;

    @GetMapping
    public Flux<ClassRoom> getAllClassRooms(){
        System.out.println("Fuu");
        return repository.findAll();
    }

}
