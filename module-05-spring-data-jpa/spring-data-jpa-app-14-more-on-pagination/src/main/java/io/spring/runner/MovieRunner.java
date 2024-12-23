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
        System.out.println("🎬 Fetching movies from the database...");

        int itr = 0;
        do {
            List<MovieDTO> movies = movieService.findAll(itr, 3);

            if (movies.isEmpty()) {
                if (itr == 0) {
                    System.out.println("❌ No movies found!");
                    break;
                }
                System.out.println("✅ Finished displaying movies!");
                break;
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
            itr++;
        } while (true);
    }
}
