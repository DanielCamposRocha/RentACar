package org.example.repository;

import org.example.model.Car;
import org.example.model.Client;
import org.example.model.Rental;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class RentalRepository implements IRentalRepository{

    private ArrayList<Rental> rentals;

    public RentalRepository() {
        rentals = new ArrayList<>();
    }
    @Override
    public void add(Rental rental) {
        rental.setId(nextIdAvailable());
        rentals.add(rental);
    }

    @Override
    public void deleteById(Long id) {
        if(!rentals.isEmpty()) {
            Iterator<Rental> iterator = rentals.iterator();
            while (iterator.hasNext()){
                Rental rental = iterator.next();
                if (rental.getId() == id) {
                    rentals.remove(rental);
                    break;
                }
            }
        }
    }

    @Override
    public ArrayList findAll() {
        return rentals;
    }

    @Override
    public Long nextIdAvailable() {
        if(!rentals.isEmpty()){
            return rentals.get(rentals.size()-1).getId() + 1;
        }
        else{
            return (long)1;
        }
    }

    @Override
    public Rental findById(Long id) {
        if(!rentals.isEmpty()){
            for (Rental rental : rentals) {
                if(rental.getId() == id){
                    return rental;
                }
            }
            return null;
        }
        return null;
    }

    @Override
    public Rental findByClient(Client client) {
        if(!rentals.isEmpty()){
            for (Rental rental : rentals) {
                if(rental.getClient().equals(client)){
                    return rental;
                }
            }
            return null;
        }
        return null;
    }

    @Override
    public Rental findByCar(Car car) {
        if(!rentals.isEmpty()){
            for (Rental rental : rentals) {
                if(rental.getCar().equals(car)){
                    return rental;
                }
            }
            return null;
        }
        return null;
    }

    @Override
    public Rental findByStartDate(LocalDate startDate) {
        if(!rentals.isEmpty()){
            for (Rental rental : rentals) {
                if(rental.getStartDate().equals(startDate)){
                    return rental;
                }
            }
            return null;
        }
        return null;
    }

    @Override
    public Rental findByEndDate(LocalDate endDate) {
        if(!rentals.isEmpty()){
            for (Rental rental : rentals) {
                if(rental.getEndDate().equals(endDate)){
                    return rental;
                }
            }
            return null;
        }
        return null;
    }

    @Override
    public void update(Rental rental) {
        Rental rentalToUpdate = findById(rental.getId());
        if(rentalToUpdate != null){
            rentalToUpdate.setCar(rental.getCar());
            rentalToUpdate.setClient(rental.getClient());
            rentalToUpdate.setStartDate(rental.getStartDate());
            rentalToUpdate.setEndDate(rental.getEndDate());
        }
    }
}
