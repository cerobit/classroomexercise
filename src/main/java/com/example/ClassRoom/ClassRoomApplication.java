package com.example.ClassRoom;

import com.example.ClassRoom.model.ClassRoom;
import com.example.ClassRoom.repository.ClassRoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ClassRoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassRoomApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ClassRoomRepository repository){
	    return args -> {
			Flux<ClassRoom> classRoomFlux = Flux.just(
			        ClassRoom.builder().block("Red").name("Cristal Room").level("Second Floor").leftHours(20).build(),
					ClassRoom.builder().block("Mountain").name("Cold Wind").level("First Floor").leftHours(50).build()
					).flatMap(p-> repository.save(p));
			classRoomFlux.thenMany( repository.findAll()).subscribe(System.out::println);
		};
	}

}


