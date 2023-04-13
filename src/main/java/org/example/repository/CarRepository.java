package org.example.repository;

import org.example.model.Car;



import java.util.ArrayList;
import java.util.Iterator;



public class CarRepository implements ICarRepository{

    private ArrayList<Car> cars;
    public CarRepository() {
        cars = new ArrayList<>();
    }

    @Override
    public void add(Car car) {
        car.setId(nextIdAvailable());
        cars.add(car);
    }

    @Override
    public void deleteById(Long id) {
        if(!isEmpty()) {
            Iterator<Car> iterator = cars.iterator();
            while (iterator.hasNext()){
                Car car = iterator.next();
                if (car.getId() == id) {
                    cars.remove(car);
                    break;
                }
            }
        }
    }

    @Override
    public ArrayList findAll() {
        return cars;
    }

    @Override
    public Long nextIdAvailable() {
        if(!isEmpty()){
            return cars.get(cars.size()-1).getId() + 1;
        }
        else{
            return (long)1;
        }
    }

    @Override
    public Car findById(Long id) {
        if(!isEmpty()){
            for (Car car : cars) {
                if(car.getId() == id){
                    return car;
                }
            }
            return null;
        }
        return null;
    }

    @Override
    public Car findBylicensePlate(String licensePlate) {
        if(!isEmpty()){
            for (Car car : cars) {
                if(car.getLicensePlate().equals(licensePlate)){
                    return car;
                }
            }
            return null;
        }
        return null;
    }

    @Override
    public void update(Car car) {
        Car carToUpdate = findById(car.getId());
        if(carToUpdate != null){
            carToUpdate.setLicensePlate(car.getLicensePlate());

        }
    }

    public boolean isEmpty(){
        if(cars.size() == 0){
            return true;
        }
        return false;
    }
}
