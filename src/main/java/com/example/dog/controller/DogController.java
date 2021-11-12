package com.example.dog.controller;

import com.example.dog.entity.Dog;
import com.example.dog.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {
    private DogService dogService;

    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getDogData(){
        List<Dog> listOfDogs = dogService.getListOfDogData();
        return new ResponseEntity<>(listOfDogs, HttpStatus.OK);

    }

    @GetMapping("/dogs/id/{id}")
    public ResponseEntity<Dog> getDogById(@PathVariable Long id){
        Dog dog = dogService.getDogById(id);
        if(dog==null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(dog,HttpStatus.OK);
        }
    }

    @GetMapping("/dogs/breed/{id}")
    public ResponseEntity<String> getDogBreedById(@PathVariable Long id){
        String dog = dogService.getDogByBreed(id);
        if(dog==null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(dog,HttpStatus.OK);
        }
    }

    @GetMapping("/dogs/name/{name}")
    public ResponseEntity<Dog> getDogByName(@PathVariable String name){
        Dog dog = dogService.getDogByName(name);
        if(dog==null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(dog,HttpStatus.OK);
        }
    }
}
