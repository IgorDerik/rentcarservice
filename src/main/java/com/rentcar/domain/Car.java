package com.rentcar.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * Class representing a car
 */
@Entity(name = "car")
public class Car {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String uid;

    private String classification;
    private String make;
    private String model;
    private int mileage;
    private boolean booked;

    public Car() {}

    public Car(String classification, String make, String model, int mileage, boolean booked) {
        this();
        this.classification = classification;
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.booked = booked;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return uid.equals(car.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, classification, make, model, mileage, booked);
    }
}