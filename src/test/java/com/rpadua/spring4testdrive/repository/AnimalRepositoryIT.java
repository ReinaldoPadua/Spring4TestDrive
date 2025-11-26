package com.rpadua.spring4testdrive.repository;

import com.rpadua.spring4testdrive.model.Animal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@ActiveProfiles("test")
@DataJpaTest
public class AnimalRepositoryIT {

    @Autowired
    private AnimalRepository animalRepository;

    @Test
    void testSaveAndFindAnimal() {
        Animal animal = new Animal();
        animal.setName("Lion");
        animal.setFamily("BigCat");
        animal.setWeight(200.00);
        animal = animalRepository.save(animal);

        Optional<Animal> found = animalRepository.findById(animal.getId());
        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("Lion");
        assertThat(found.get().getFamily()).isEqualTo("BigCat");
        assertThat(found.get().getWeight()).isEqualTo(200D);
    }

    @Test
    void testDeleteAnimalById() {
        Animal animal = new Animal();
        animal.setName("Lion");
        animal.setFamily("BigCat");
        animal = animalRepository.save(animal);

        Long id = animal.getId();
        animalRepository.deleteAnimalById(id);

        Optional<Animal> found = animalRepository.findById(id);
        assertThat(found).isNotPresent();
    }
}