package org.example.repository;

import org.example.model.Car;
import org.example.model.Client;
import org.example.model.Rental;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class RentalRepositoryTest {
    RentalRepository repository;
    Car car1;
    Client client1;

    LocalDate date1,date2;
    @BeforeEach
    void setUp() {
        repository = new RentalRepository();
        date1=LocalDate.of(2022,1,1);
        date2=LocalDate.of(2022,1,11);
        car1= new Car("AAAA");
        client1 = new Client("87896685P", "María", "Rodríguez");
        Rental rental1=new Rental(date1,date2,client1,car1);
        repository.add(rental1);

    }

    @Test
    void add() {
        Client client2 = new Client("39887554G", "Pedro", "Fernández");
        LocalDate date1=LocalDate.of(2022,2,1);
        LocalDate date2=LocalDate.of(2022,2,11);
        Car car2= new Car("BBBB");
        Rental rental2=new Rental(date1,date2,client2,car2);
        repository.add(rental2);
        Assertions.assertEquals(rental2, repository.findById(2L));
        Client client3 = new Client("59887995L", "Juan", "Pérez");
        LocalDate date3=LocalDate.of(2022,2,1);
        LocalDate date4=LocalDate.of(2022,2,11);
        Car car3= new Car("BBBB");
        Rental rental3=new Rental(date3,date4,client3,car3);
        repository.add(rental3);
        Assertions.assertEquals(rental3, repository.findById(3L));
    }

    @Test
    void findAll() {
        Assertions.assertEquals(1, repository.findAll().size());
        Client client2 = new Client("39887554G", "Pedro", "Fernández");
        LocalDate date1=LocalDate.of(2022,2,1);
        LocalDate date2=LocalDate.of(2022,2,11);
        Car car2= new Car("BBBB");
        Rental rental2=new Rental(date1,date2,client2,car2);
        repository.add(rental2);
        Assertions.assertEquals(2, repository.findAll().size());
    }

    @Test
    void deleteById() {
        Assertions.assertEquals(1, repository.findAll().size());
        repository.deleteById(2L); // Don't exist
        Assertions.assertEquals(1, repository.findAll().size());
        repository.deleteById(1L);
        Assertions.assertEquals(0, repository.findAll().size());
    }

    @Test
    void nextIdAvailable() {
        Assertions.assertEquals(2, repository.nextIdAvailable());
        Client client2 = new Client("39887554G", "Pedro", "Fernández");
        LocalDate date1=LocalDate.of(2022,2,1);
        LocalDate date2=LocalDate.of(2022,2,11);
        Car car2= new Car("BBBB");
        Rental rental2=new Rental(date1,date2,client2,car2);
        repository.add(rental2);
        Assertions.assertEquals(3, repository.nextIdAvailable());
        repository.deleteById(1L);
        Assertions.assertEquals(3, repository.nextIdAvailable());
    }

    @Test
    void findById() {
        Assertions.assertEquals(car1, repository.findById(1L).getCar());
        Assertions.assertEquals(client1, repository.findById(1L).getClient());
    }
    @Test
    void findByCar(){
        Assertions.assertEquals(1, repository.findByCar(car1).getId());
    }

    @Test
    void findByClient(){
        Assertions.assertEquals(1, repository.findByClient(client1).getId());
    }

    @Test
    void findByStartDate(){
        Assertions.assertEquals(1, repository.findByStartDate(date1).getId());
    }

    @Test
    void findByEndDate(){
        Assertions.assertEquals(1, repository.findByEndDate(date2).getId());
    }

    @Test
    void update(){
        Assertions.assertEquals(client1, repository.findById(1L).getClient());
        Client client2 = new Client("39887554G", "Pedro", "Fernández");
        LocalDate date1=LocalDate.of(2022,2,1);
        LocalDate date2=LocalDate.of(2022,2,11);
        Car car2= new Car("BBBB");
        Rental rental2=new Rental(date1,date2,client2,car2,1L);
        repository.update(rental2);
        Assertions.assertEquals(rental2.getEndDate(), repository.findById(1L).getEndDate());
        Assertions.assertEquals(rental2.getStartDate(), repository.findById(1L).getStartDate());
        Assertions.assertEquals(rental2.getClient(), repository.findById(1L).getClient());
        Assertions.assertEquals(rental2.getCar(), repository.findById(1L).getCar());
    }
}
