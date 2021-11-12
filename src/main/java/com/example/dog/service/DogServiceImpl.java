package com.example.dog.service;

import com.example.dog.entity.Dog;
import com.example.dog.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {
    private DogRepository dogRepository ;

    @Autowired
    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @Override
    public List<Dog> getListOfDogData() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public String getDogByBreed(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(id));
        String breed = optionalBreed.orElseThrow(()->new DogNotFoundException("No dog breed found by id"+id));
        return breed;
    }

    @Override
    public Dog getDogByName(String name) {
        Optional<Dog> dog = Optional.ofNullable(dogRepository.findDogByName(name));
        return dog.orElseThrow(()->new DogNotFoundException("No dog found by name"+name));
    }

    @Override
    public List<String> getAllBreeds(){
        return dogRepository.findAllBreed();
    }

    @Override
    public List<String> getAllNames(){
        return dogRepository.findAllNames() ;
    }

    @Override
    public Dog getDogById(Long id) {

        Optional<Dog> dog = Optional.ofNullable(dogRepository.findDogById(id));
        Dog d = dog.orElseThrow(()->new DogNotFoundException("No dog found by id"+id));
        return d ;

    }
}
