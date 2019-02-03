package com.rentcar.web;

import com.rentcar.domain.Status;
import com.rentcar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rentcar.domain.Car;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    private final CarService cars;

    @Autowired
    public CarController(final CarService cars) {
        this.cars = cars;
    }

    @PostMapping("/cars")
    public String add(@RequestBody Car car) {
        Car addedCar = this.cars.add(car);
        return addedCar.getUid();
    }

    @PostMapping("/cars/{uid}")
    public ResponseEntity<Car> setBookingStatus(@RequestBody Status status, @PathVariable String uid) {

        Optional<Car> optionalCar = this.cars.setBookingStatus(status, uid);

        return this.cars.getResponse(optionalCar.orElse(null));
    }

    @GetMapping("/cars")
    public List<Car> getAll() {
        return this.cars.getAll();
    }

    @GetMapping("/cars/available")
    public List<Car> getAvailable() {
        return this.cars.getAvailable();
    }

    @GetMapping("/cars/{uid}")
    public ResponseEntity<Car> getCarByUid(@PathVariable String uid) {
        Optional<Car> optionalCar = this.cars.getCarByUid(uid);

        return this.cars.getResponse(optionalCar.orElse(null));
    }

}