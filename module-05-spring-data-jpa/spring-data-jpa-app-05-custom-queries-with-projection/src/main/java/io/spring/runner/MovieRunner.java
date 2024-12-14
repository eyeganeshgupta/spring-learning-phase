package io.spring.runner;

import io.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MovieRunner implements CommandLineRunner {
    private final MovieService movieService;

    @Autowired
    public MovieRunner(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Fetching and printing movies with high ratings using projection
        System.out.println("\nMovies with Ratings Above 8.0:");
        movieService.getMoviesWithHighRatings(8.0).forEach(projection ->
                System.out.println(projection.getTitle() + " - Rating: " + projection.getRating())
        );
    }
}
