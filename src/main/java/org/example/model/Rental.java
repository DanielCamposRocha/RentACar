package org.example.model;

import java.time.LocalDate;

public class Rental {
    private LocalDate startDate;
    private LocalDate endDate;
    private Client client;
    private Car car;
    private Long id;

    public Rental(LocalDate startDate, LocalDate endDate, Client client, Car car, Long id) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
        this.car = car;
        this.id = id;
    }

    public Rental(LocalDate startDate, LocalDate endDate, Client client, Car car) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
        this.car = car;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
