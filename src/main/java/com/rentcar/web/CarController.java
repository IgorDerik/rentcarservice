package com.rentcar.web;

import com.rentcar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.rentcar.domain.Car;
import com.rentcar.web.forms.Error;
import com.rentcar.web.forms.Result;
import com.rentcar.web.forms.Success;

import java.util.List;

@RestController
public class CarController {

    private final CarService cars;

    @Autowired
    public CarController(final CarService cars) {
        this.cars = cars;
    }

    @PostMapping("/cars")
    public Result add(@RequestBody Car car) {
        return new Success<Car>(this.cars.add(car));
    }

    @GetMapping("/cars")
    public List<Car> getAll() {
        return this.cars.getAll();
    }

}