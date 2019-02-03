package com.rentcar.service;

import com.google.common.collect.Lists;
import com.rentcar.domain.Car;
import com.rentcar.domain.Status;
import com.rentcar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public ResponseEntity<Car> getResponse(Car car) {

        if (car != null) {
            return ResponseEntity.ok(car);
        } else {
            return ResponseEntity.status(404).build();
        }

    }

    @Override
    public List<Car> getAll() {
        return Lists.newArrayList(this.repository.findAll());
    }

    @Override
    public List<Car> getAvailable() {
        return getAll()
                .parallelStream()
                .filter(car -> (!car.isBooked()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Car> getCarByUid(String uid) {
        return this.repository.findById(uid);
    }

    @Override
    public Optional<Car> setBookingStatus(Status status, String uid) {

        Optional<Car> optionalCar = getCarByUid(uid);

        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            car.setBooked(status.isBooked());
            add(car);
        }

        return optionalCar;
    }
}