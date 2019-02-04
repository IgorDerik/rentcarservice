package com.rentcar.service;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import com.rentcar.domain.Car;
import com.rentcar.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {

    @Autowired
    private CarService service;

    @Test
    public void checkIfCarSavedInBase() {
        Car car = this.service.add(new Car("A","UKR","FUTURE",100,true));
        List<Car> result = this.service.getAll();
        assertTrue(result.contains(car));
    }

    @Test
    public void checkIfCarReturnedFromBase() {
        Car car = this.service.add(new Car("A","UKR","FUTURE",100,true));
        Optional<Car> optionalCar = this.service.getCarByUid(car.getUid());
        Car result = optionalCar.orElse(null);
        assertEquals(car,result);
    }

}