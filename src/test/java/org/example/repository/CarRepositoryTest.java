package org.example.repository;

import org.example.model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryTest {

    CarRepository repository;
    @BeforeEach
    void setUp() {
        repository = new CarRepository();
        Car car1=new Car("AACC");
        repository.add(car1);
    }

    @Test
    void add() {
        Car car2=new Car("AABB");
        repository.add(car2);
        Assertions.assertEquals(car2, repository.findById(2L));
    }

    @Test
    void deleteById() {
        Car car2=new Car("AABB");
        repository.add(car2);
        Assertions.assertEquals(2, repository.findAll().size());
        repository.deleteById(3L); // Don't exist
        Assertions.assertEquals(2, repository.findAll().size());
        repository.deleteById(2L);
        Assertions.assertEquals(1, repository.findAll().size());
    }

    @Test
    void findAll() {
        Assertions.assertEquals(1,repository.findAll().size());
        Car car2=new Car("AABB");
        repository.add(car2);
        Assertions.assertEquals(2, repository.findAll().size());
    }

    @Test
    void nextIdAvailable() {
        Assertions.assertEquals(2, repository.nextIdAvailable());
        Car car2=new Car("AABB");
        repository.add(car2);
        Assertions.assertEquals(3, repository.nextIdAvailable());
    }

    @Test
    void findById() {
        Assertions.assertEquals("AACC", repository.findById(1L).getLicensePlate());

    }

    @Test
    void findBylicensePlate() {
        Assertions.assertEquals(1, repository.findBylicensePlate("AACC").getId());

    }

    @Test
    void update() {
        Assertions.assertEquals("AACC", repository.findById(1L).getLicensePlate());
        Car car1=new Car(1L,"JJJJ");
        repository.update(car1);
        Assertions.assertEquals("JJJJ", repository.findById(1L).getLicensePlate());
    }
}