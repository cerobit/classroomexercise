package com.example.ClassRoom.controller;


import com.example.ClassRoom.model.ClassRoom;
import com.example.ClassRoom.repository.ClassRoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/classroom")
@AllArgsConstructor
public class ClassRoomController {

    private ClassRoomRepository repository;

    /**
     * Return all Books
     * @return <Flux>
     */
    @GetMapping
    public Flux<ClassRoom> getAllClassRooms(){
        return repository.findAll();
    }

    /**
     * @param id  String  unique identifier
     * @return <Mono> repository
     */
    @GetMapping("{id}")
    public Mono<ResponseEntity<ClassRoom>> getClassRoomByID(@PathVariable String id){
        return repository.findById(id).map(classroom -> ResponseEntity.ok(classroom))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public Flux<ClassRoom> getClassRoomByName(@PathVariable String name){
        return repository.findByName(name);
    }

    @PutMapping("{id}")
    public Mono<ResponseEntity<ClassRoom>> updateClassRoom(@PathVariable String id, @RequestBody ClassRoom classRoomNewData ) {
        return repository.findById(id)
                .flatMap(classRoom -> {
                    classRoom.setBlock(classRoomNewData.getBlock());
                    classRoom.setCapacity(classRoomNewData.getCapacity());
                    classRoom.setLeftHours(classRoomNewData.getLeftHours());
                    classRoom.setLevel(classRoomNewData.getName());
                    classRoom.setName(classRoomNewData.getName());
                    return repository.save(classRoom);
                }).map(updateClassRoom -> ResponseEntity.ok(updateClassRoom))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public Mono<ResponseEntity<Void>> deleteClassRoom(@PathVariable String id){
        return repository.findById(id)
                .flatMap( classRoom ->  repository.delete( classRoom)
                .then(Mono.just(ResponseEntity.ok().<Void>build())))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

   @DeleteMapping
    public Mono<Void> deleteAllClassRooms(){
        return repository.deleteAll();
   }

}
