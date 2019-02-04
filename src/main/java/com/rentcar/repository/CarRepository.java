package com.rentcar.repository;

import com.rentcar.domain.Car;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface implements main crud operations
 */
public interface CarRepository extends CrudRepository<Car, String> {
}