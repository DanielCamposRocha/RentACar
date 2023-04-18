package org.example.repository;

import org.example.model.Rental;
import org.example.model.Client;
import org.example.model.Car;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IRentalRepository {
    void add(Rental rental);
    void deleteById(Long id);
    ArrayList findAll();
    public Long nextIdAvailable();
    Rental findById(Long id);
    Rental findByClient(Client client);
    Rental findByCar(Car car);

    Rental findByStartDate(LocalDate startDate);

    Rental findByEndDate(LocalDate endDate);
    void update(Rental rental);
}
