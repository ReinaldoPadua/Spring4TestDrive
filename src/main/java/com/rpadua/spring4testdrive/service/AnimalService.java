package com.rpadua.spring4testdrive.service;

import com.rpadua.spring4testdrive.model.Animal;
import com.rpadua.spring4testdrive.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> findAll(){
        return animalRepository.findAll();
    }

    public Animal findById(Long id){
        return animalRepository.findById(id).orElse(null);
    }

    public Animal save(Animal animal){
        return animalRepository.save(animal);
    }

    public void delete(Long id){
        animalRepository.deleteAnimalById(id);
    }
}
