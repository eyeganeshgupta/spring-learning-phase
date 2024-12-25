package io.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class BookingId implements Serializable {
    @Column(name = "flight_id")
    private Long flightId;

    @Column(name = "passenger_id")
    private Long passengerId;

    // Default constructor
    public BookingId() {

    }

    // Parameterized constructor
    public BookingId(Long flightId, Long passengerId) {
        this.flightId = flightId;
        this.passengerId = passengerId;
    }

    // Getters and Setters
    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    // toString method
    @Override
    public String toString() {
        return "==================== BookingId ====================\n" +
                "Flight ID    : " + flightId + "\n" +
                "Passenger ID : " + passengerId + "\n" +
                "===================================================";
    }
}
