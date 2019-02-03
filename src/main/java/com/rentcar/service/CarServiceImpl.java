package com.rentcar.service;

import com.google.common.collect.Lists;
import com.rentcar.domain.Car;
import com.rentcar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository repository;

    @Autowired
    public CarServiceImpl(final CarRepository repository) {
        this.repository = repository;
    }

    @Override
    public Car add(Car car) {
        return this.repository.save(car);
    }

    @Override
    public List<Car> getAll() {
        return Lists.newArrayList(this.repository.findAll());
    }
}