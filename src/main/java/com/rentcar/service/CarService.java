package com.rentcar.service;

import com.rentcar.domain.Car;

import java.util.List;

public interface CarService {

    Car add(Car car);

    List<Car> getAll();

}
