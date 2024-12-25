package io.spring.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bookings")
public class Booking {
    @EmbeddedId
    private BookingId id;

    @Column(name = "booking_date")
    private Date bookingDate;

    @Column(name = "seat_number")
    private String seatNumber;

    // Default constructor
    public Booking() {

    }

    // Parameterized constructor
    public Booking(BookingId id, Date bookingDate, String seatNumber) {
        this.id = id;
        this.bookingDate = bookingDate;
        this.seatNumber = seatNumber;
    }

    // Getters and Setters
    public BookingId getId() {
        return id;
    }

    public void setId(BookingId id) {
        this.id = id;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    // toString method
    @Override
    public String toString() {
        return "==================== Booking ====================\n" +
                "Booking ID   : " + id + "\n" +
                "Booking Date : " + bookingDate + "\n" +
                "Seat Number  : " + seatNumber + "\n" +
                "=================================================";
    }
}
