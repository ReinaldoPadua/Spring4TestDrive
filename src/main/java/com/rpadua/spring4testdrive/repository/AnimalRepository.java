package com.rpadua.spring4testdrive.repository;

import com.rpadua.spring4testdrive.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long>{
    void deleteAnimalById(Long id);
}
