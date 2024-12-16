package io.spring.runner;

import io.spring.dto.MovieDTO;
import io.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class MovieRunner implements CommandLineRunner {
    private final MovieService movieService;

    @Autowired
    public MovieRunner(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Find movies by title
        List<MovieDTO> moviesByTitle = movieService.findMoviesByTitle("Inception");
        System.out.println("Movies with title 'Inception':");
        moviesByTitle.forEach(System.out::println);

        // Find movies with a minimum rating of 8.0
        List<MovieDTO> highRatedMovies = movieService.findMoviesByMinimumRating(new BigDecimal("8.0"));
        System.out.println("Movies with rating >= 8.0:");
        highRatedMovies.forEach(System.out::println);
    }
}
