package io.spring.runner;

import io.spring.dto.MovieDTO;
import io.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        String directorName = "Nolan"; // Example input
        List<MovieDTO> movies = movieService.getMoviesByDirectorName(directorName);

        System.out.println("Movies directed by " + directorName + ":");
        for (MovieDTO movie : movies) {
            System.out.println(movie);
        }
    }
}
