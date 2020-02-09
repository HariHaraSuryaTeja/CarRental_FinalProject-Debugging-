package com.example.debuggingproj;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    //SINGLETON PATTERN
    private static CarRepository instance = null;
    private List<Cars> cars = new ArrayList<Cars>();

    private CarRepository() {
        Cars cars = new Cars();
        cars.year = 2019;
        cars.company = "Honda";
        cars.type = "Sedan";
        cars.name = "Civic";
        this.cars.add(cars);
    }


    public static CarRepository getInstance() {
        if (instance == null) {
            instance = new CarRepository();
        }
        return instance;
    }

    public void addAnimal(Cars cars) {
        this.cars.add(cars);
    }

    public List<Cars> getCars() {
        return this.cars;
    }
}