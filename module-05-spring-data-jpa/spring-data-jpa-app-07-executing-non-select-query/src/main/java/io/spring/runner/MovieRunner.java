package io.spring;

import io.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MovieRunner implements CommandLineRunner {
    private final MovieService movieService;

    @Autowired
    public MovieRunner(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Update the rating of a movie by its ID
        Integer movieIdToUpdate = 1;
        BigDecimal newRating = new BigDecimal("8.5");
        System.out.println("Updating rating...");
        movieService.updateMovieRating(movieIdToUpdate, newRating);

        // Delete a movie by its title
        String titleToDelete = "Inception";
        System.out.println("\nDeleting a movie...");
        movieService.deleteMovieByTitle(titleToDelete);

        // Insert a new movie into the database
        String newTitle = "Interstellar";
        Integer yearReleased = 2014;
        String directorName = "Christopher Nolan";
        String genre = "Sci-Fi";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date releaseDate = sdf.parse("2014-11-07");
        BigDecimal rating = new BigDecimal("9.0");

        System.out.println("\nInserting a new movie...");
        movieService.insertNewMovie(newTitle, yearReleased, directorName, genre, releaseDate, rating);
    }
}
