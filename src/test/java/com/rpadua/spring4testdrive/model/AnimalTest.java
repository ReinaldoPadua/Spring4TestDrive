package com.rpadua.spring4testdrive.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void testNoArgsConstructorAndSettersGetters() {
        Animal animal = new Animal();

        animal.setId(1L);
        animal.setName("Leão");
        animal.setFamily("Felídeos");
        animal.setWeight(190.5);

        assertEquals(1L, animal.getId());
        assertEquals("Leão", animal.getName());
        assertEquals("Felídeos", animal.getFamily());
        assertEquals(190.5, animal.getWeight());
    }

    @Test
    void testAllArgsConstructor() {
        Animal animal = new Animal(2L, "Elefante", "Elefantídeos", 5400.0);

        assertEquals(2L, animal.getId());
        assertEquals("Elefante", animal.getName());
        assertEquals("Elefantídeos", animal.getFamily());
        assertEquals(5400.0, animal.getWeight());
    }

    @Test
    void testSetters() {
        Animal animal = new Animal();
        animal.setName("Girafa");
        assertEquals("Girafa", animal.getName());
        animal.setFamily("Girafídeos");
        assertEquals("Girafídeos", animal.getFamily());
        animal.setWeight(800.0);
        assertEquals(800.0, animal.getWeight());
    }
}