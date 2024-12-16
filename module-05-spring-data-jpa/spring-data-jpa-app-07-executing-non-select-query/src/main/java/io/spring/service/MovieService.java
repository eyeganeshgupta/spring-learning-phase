package io.spring.service;

import io.spring.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Update the rating of a movie by its ID
    public void updateMovieRating(Integer movieId, BigDecimal newRating) {
        int rowsAffected = movieRepository.updateMovieRating(movieId, newRating);
        if (rowsAffected > 0) {
            System.out.println("Successfully updated the rating for movie ID: " + movieId);
        } else {
            System.out.println("No movie found with ID: " + movieId);
        }
    }

    // Delete a movie by its title
    public void deleteMovieByTitle(String title) {
        int rowsAffected = movieRepository.deleteMovieByTitle(title);
        if (rowsAffected > 0) {
            System.out.println("Successfully deleted the movie with title: " + title);
        } else {
            System.out.println("No movie found with title: " + title);
        }
    }

    // Insert a new movie into the database
    public void insertNewMovie(String title, Integer yearReleased, String directorName, String genre,
                               Date releaseDate, BigDecimal rating) {
        int rowsAffected = movieRepository.insertMovie(title, yearReleased, directorName, genre, releaseDate, rating);
        if (rowsAffected > 0) {
            System.out.println("Successfully inserted a new movie: " + title);
        } else {
            System.out.println("Failed to insert the new movie.");
        }
    }
}
