package io.spring.runner;

import io.spring.dto.BookingDTO;
import io.spring.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class BookingRunner implements CommandLineRunner {
    private final BookingService bookingService;

    @Autowired
    public BookingRunner(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n****************************************************");
        System.out.println("✈️  WELCOME TO SKYHIGH AIRLINES BOOKING SYSTEM ✈️");
        System.out.println("****************************************************\n");

        // Step 1: Create a new booking
        System.out.println("🌟 Step 1: Creating a new booking...");
        BookingDTO newBooking = new BookingDTO(
                12345L, 67890L, new Date(), "12A"
        );
        BookingDTO createdBooking = bookingService.createBooking(newBooking);
        System.out.println("✅ Booking Created Successfully!");
        System.out.println(createdBooking);

        // Step 2: Retrieve the created booking
        System.out.println("\n🌟 Step 2: Retrieving the created booking...");
        Long flightId = 12345L;
        Long passengerId = 67890L;
        Optional<BookingDTO> retrievedBooking = bookingService.getBooking(flightId, passengerId);

        retrievedBooking.ifPresentOrElse(
                dto -> {
                    System.out.println("✅ Booking Retrieved Successfully!");
                    System.out.println(dto);
                },
                () -> System.out.println("❌ No booking found for Flight ID: " + flightId + ", Passenger ID: " + passengerId)
        );

        // Step 3: Delete the created booking
        System.out.println("\n🌟 Step 3: Deleting the created booking...");
        if (retrievedBooking.isPresent()) {
            bookingService.deleteBooking(flightId, passengerId);
            System.out.println("✅ Booking Deleted Successfully!");
        } else {
            System.out.println("❌ Unable to delete. Booking not found.");
        }

        System.out.println("\n****************************************************");
        System.out.println("🎉 Thank you for using SkyHigh Airlines! Have a great day! ✈️");
        System.out.println("****************************************************\n");
    }
}
