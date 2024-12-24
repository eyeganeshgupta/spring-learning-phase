package io.spring;

import io.spring.dto.MovieDTO;
import io.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class MovieRunner implements CommandLineRunner {

    private final MovieService movieService;

    @Autowired
    public MovieRunner(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🎬 Welcome to the Paginated Movie Finder!");

        System.out.print("📅 Enter a release year to search for movies (greater than or equal): ");
        int yearReleased = scanner.nextInt();

        int pageSize = 2;
        int currentPage = 0;

        System.out.println("🔍 Searching for movies released in or after " + yearReleased + "...");

        while (true) {
            List<MovieDTO> movies = movieService.findMoviesByYearReleased(yearReleased, currentPage, pageSize);

            if (movies.isEmpty()) {
                if (currentPage == 0) {
                    System.out.println("❌ No movies found for the given criteria!");
                }
                break;
            }

            System.out.println("🍿 Page " + (currentPage + 1) + ":");
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

            currentPage++; // Move to the next page
        }

        System.out.println("✅ Finished displaying all movies!");
        scanner.close();
    }
}
