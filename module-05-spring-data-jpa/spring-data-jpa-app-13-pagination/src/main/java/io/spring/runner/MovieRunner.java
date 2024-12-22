package io.spring;

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
        System.out.println("🎬 Fetching movies from the database...");

        List<MovieDTO> movies = movieService.findAll();

        if (movies.isEmpty()) {
            System.out.println("❌ No movies found!");
        } else {
            System.out.println("🍿 Here are the movies we found:");
            movies.forEach(movie -> {
                System.out.println("--------------------------------------------------");
                System.out.println("🎥 Movie ID: " + movie.getMovieId());
                System.out.println("📖 Title: " + movie.getTitle());
                System.out.println("📅 Year Released: " + movie.getYearReleased());
                System.out.println("🎬 Director: " + movie.getDirectorName());
                System.out.println("🎭 Genre: " + movie.getGenre());
                System.out.println("⭐ Rating: " + movie.getRating());
                System.out.println("--------------------------------------------------");
            });
        }
        System.out.println("✅ Finished displaying movies!");
    }
}
