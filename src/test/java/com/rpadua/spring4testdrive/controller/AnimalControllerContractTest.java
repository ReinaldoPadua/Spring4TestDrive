package com.rpadua.spring4testdrive.controller;

import com.rpadua.spring4testdrive.model.Animal;
import com.rpadua.spring4testdrive.service.AnimalService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@WebMvcTest(controllers = AnimalController.class)
@AutoConfigureJsonTesters
class AnimalControllerContractTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AnimalService animalService;

    @Autowired
    private JacksonTester<Animal> json;

    @Test
    void shouldReturnListOfAnimals() throws Exception {
        Animal animal = new Animal();
        animal.setId(1L);
        animal.setName("Tobby");
        animal.setFamily("Dog");
        animal.setWeight(12D);

        Mockito.when(animalService.findAll()).thenReturn(List.of(animal));

        mockMvc.perform(get("/animals"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("Tobby"))
                .andExpect(jsonPath("$[0].family").value("Dog"))
                .andExpect(jsonPath("$[0].weight").value(12D));
    }

    @Test
    void shouldCreateAnimal() throws Exception {
        Animal toCreate = new Animal();
        toCreate.setName("Tobby");
        toCreate.setFamily("Dog");
        toCreate.setWeight(12D);

        Animal created = new Animal();
        created.setId(1L);
        created.setName("Tobby");
        created.setFamily("Dog");
        created.setWeight(12D);

        Mockito.when(animalService.save(any(Animal.class))).thenReturn(created);

        mockMvc.perform(post("/animals")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json.write(toCreate).getJson()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Tobby"))
                .andExpect(jsonPath("$.family").value("Dog"))
                .andExpect(jsonPath("$.weight").value(12D));
    }

    @Test
    void shouldReturnAnimalById() throws Exception {
        Animal animal = new Animal();
        animal.setId(1L);
        animal.setName("Tobby");
        animal.setFamily("Dog");
        animal.setWeight(12D);

        Mockito.when(animalService.findById(eq(1L))).thenReturn(animal);

        mockMvc.perform(get("/animals/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Tobby"))
                .andExpect(jsonPath("$.family").value("Dog"))
                .andExpect(jsonPath("$.weight").value(12D));
    }

    @Test
    void shouldDeleteAnimal() throws Exception {
        Mockito.doNothing().when(animalService).delete(1L);

        mockMvc.perform(delete("/animals/1"))
                .andExpect(status().isOk());
    }
}