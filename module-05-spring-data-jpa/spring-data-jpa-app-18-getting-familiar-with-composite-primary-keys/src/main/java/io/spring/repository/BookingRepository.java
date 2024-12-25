package io.spring.repository;

import io.spring.entity.Booking;
import io.spring.entity.BookingId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, BookingId> {

}
