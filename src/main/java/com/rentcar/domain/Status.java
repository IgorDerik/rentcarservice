package com.rentcar.domain;

public class Status {

    private boolean booked;

    public Status() {}

    public Status(boolean booked) {
        this.booked = booked;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}