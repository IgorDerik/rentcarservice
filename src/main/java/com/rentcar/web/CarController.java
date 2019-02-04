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

    /**
     * Add new car
     * @param car to be added
     * @return car uid
     */
    @PostMapping("/cars")
    public String add(@RequestBody Car car) {
        Car addedCar = this.cars.add(car);
        return addedCar.getUid();
    }

    /**
     * Change booking status
     * @param status define booking status
     * @param uid of car which status should be changed
     * @return car with updated status or responses with 404 http status code if the car uid does not exist
     */
    @PostMapping("/cars/{uid}")
    public ResponseEntity<Car> setBookingStatus(@RequestBody Status status, @PathVariable String uid) {

        Optional<Car> optionalCar = this.cars.setBookingStatus(status, uid);

        return this.cars.getResponse(optionalCar.orElse(null));
    }

    /**
     * List of all cars
     * @return list of cars
     */
    @GetMapping("/cars")
    public List<Car> getAll() {
        return this.cars.getAll();
    }

    /**
     * List of all available cars
     * Car to be considered as available if has false booking status
     * @return list of cars
     */
    @GetMapping("/cars/available")
    public List<Car> getAvailable() {
        return this.cars.getAvailable();
    }

    /**
     * Get a car by uid
     * @param uid of car which should be returned
     * @return requested car or responses with 404 http status code if the car uid does not exist
     */
    @GetMapping("/cars/{uid}")
    public ResponseEntity<Car> getCarByUid(@PathVariable String uid) {
        Optional<Car> optionalCar = this.cars.getCarByUid(uid);

        return this.cars.getResponse(optionalCar.orElse(null));
    }

}