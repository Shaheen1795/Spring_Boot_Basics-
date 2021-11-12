package com.example.dog.service;

import com.example.dog.entity.Dog;

import java.util.List;

public interface DogService {
    List<Dog> getListOfDogData();

    Dog getDogById(Long id);

    String getDogByBreed(Long id);

    Dog getDogByName(String name);

    List<String> getAllBreeds();

    public List<String> getAllNames();



}
