package com.example.dog.repository;

import com.example.dog.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog,Long> {

    @Query("select d.id, d.breed from Dog d where d.id=:id")
    String findBreedById(Long id) ;

    @Query("select d.id, d.breed from Dog d")
    List<String> findAllBreed();

    @Query("select d.id, d.name from  Dog d")
    List<String> findAllNames();

    @Query("select d from Dog d where d.name=:name")
    Dog findDogByName(String name);

    @Query("select d from Dog d where d.id=:id")
    Dog findDogById(Long id);



}
