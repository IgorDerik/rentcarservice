package com.rentcar.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rentcar.domain.Car;
import com.rentcar.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;

import static org.junit.Assert.*;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarService cars;

    @Test
    public void getAll() throws Exception {

        List<Car> list = Collections.singletonList(new Car("A","UKR","FUTURE",100,true));
        ObjectMapper mapper = new ObjectMapper();
        given(this.cars.getAll()).willReturn(list);

        this.mvc.perform(get("/cars").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(list)));
    }

    @Test
    public void getAvailable() throws Exception {
        List<Car> list = new ArrayList<>();
        list.add(new Car("A","UKR","FUTURE",100,true));
        list.add(new Car("B","USA","VOLVO",999,false));
        list.add(new Car("C","CHINA","BMW",111,true));
        list.add(new Car("D","SPAIN","WOLF",222,false));
        list.forEach( car -> this.cars.add(car) );
        List<Car> availableList = list.stream().filter(car -> !car.isBooked()).collect(Collectors.toList());
        given(this.cars.getAvailable()).willReturn(availableList);
        ObjectMapper mapper = new ObjectMapper();

        this.mvc.perform(get("/cars/available").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(availableList)));
    }
}