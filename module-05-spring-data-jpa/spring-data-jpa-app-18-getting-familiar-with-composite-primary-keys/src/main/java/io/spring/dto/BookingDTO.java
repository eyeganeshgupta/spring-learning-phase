package io.spring.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BookingDTO {
    private Long flightId;
    private Long passengerId;
    private Date bookingDate;
    private String seatNumber;

    public BookingDTO() {

    }

    public BookingDTO(Long flightId, Long passengerId, Date bookingDate, String seatNumber) {
        this.flightId = flightId;
        this.passengerId = passengerId;
        this.bookingDate = bookingDate;
        this.seatNumber = seatNumber;
    }

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

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM dd yyyy HH:mm:ss");

        return "\n" +
                "------------------- BOOKING DETAILS -------------------\n" +
                "🌟 Flight ID     : " + flightId + "\n" +
                "🧳 Passenger ID  : " + passengerId + "\n" +
                "📅 Booking Date  : " + dateFormat.format(bookingDate) + "\n" +
                "💺 Seat Number   : " + seatNumber + "\n" +
                "-------------------------------------------------------\n";
    }
}
