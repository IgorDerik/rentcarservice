package com.rentcar.service;

import com.rentcar.domain.Car;
import com.rentcar.domain.Status;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Car add(Car car);

    ResponseEntity<Car> getResponse(Car car);

    List<Car> getAll();

    List<Car> getAvailable();

    Optional<Car> getCarByUid(String uid);

    Optional<Car> setBookingStatus(Status status, String uid);
}