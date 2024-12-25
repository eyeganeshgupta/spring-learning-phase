package io.spring.service;

import io.spring.dto.BookingDTO;
import io.spring.entity.Booking;
import io.spring.entity.BookingId;
import io.spring.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public BookingDTO createBooking(BookingDTO bookingDTO) {
        // Mapping DTO to Entity
        Booking booking = new Booking(
                new BookingId(bookingDTO.getFlightId(), bookingDTO.getPassengerId()),
                bookingDTO.getBookingDate(),
                bookingDTO.getSeatNumber()
        );

        // Save to database
        Booking savedBooking = bookingRepository.save(booking);

        // Map Entity back to DTO and return
        return new BookingDTO(
                savedBooking.getId().getFlightId(),
                savedBooking.getId().getPassengerId(),
                savedBooking.getBookingDate(),
                savedBooking.getSeatNumber()
        );
    }

    // Retrieve a booking by composite key
    public Optional<BookingDTO> getBooking(Long flightId, Long passengerId) {
        Optional<Booking> optionalBooking = bookingRepository.findById(new BookingId(flightId, passengerId));

        // Map Entity to DTO if present
        return optionalBooking.map(booking -> new BookingDTO(
                booking.getId().getFlightId(),
                booking.getId().getPassengerId(),
                booking.getBookingDate(),
                booking.getSeatNumber()
        ));
    }

    // Delete a booking by composite key
    public void deleteBooking(Long flightId, Long passengerId) {
        bookingRepository.deleteById(new BookingId(flightId, passengerId));
    }
}
