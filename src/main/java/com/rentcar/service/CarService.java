package com.rentcar.service;

import com.rentcar.domain.Car;
import com.rentcar.domain.Status;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CarService {

    /**
     * Add new car
     * @param car to be added
     * @return car was added
     */
    Car add(Car car);

    /**
     * Based on car object returns car of 404 status
     * @param car to be checked
     * @return car if it is not null or 404 status
     */
    ResponseEntity<Car> getResponse(Car car);

    /**
     * Get all cars
     * @return list of all cars
     */
    List<Car> getAll();

    /**
     * Get only available cars
     * @return list of available cars
     */
    List<Car> getAvailable();

    /**
     * Get car by it's iud
     * @param uid of car to be returned
     * @return car if exists
     */
    Optional<Car> getCarByUid(String uid);

    /**
     * Change booking status
     * @param status to be changed on
     * @param uid of car which status should ne changed
     * @return car if exists
     */
    Optional<Car> setBookingStatus(Status status, String uid);
}