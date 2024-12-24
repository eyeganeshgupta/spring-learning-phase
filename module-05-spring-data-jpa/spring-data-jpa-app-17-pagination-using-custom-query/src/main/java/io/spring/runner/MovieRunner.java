package io.spring.runner;

import io.spring.dto.MovieDTO;
import io.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
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

        System.out.println("🎬 Welcome to the Advanced Movie Finder!");

        // Prompt user for filtering criteria
        System.out.print("⭐ Enter minimum rating (e.g., 7.5): ");
        BigDecimal minRating = scanner.nextBigDecimal();

        System.out.print("🗣️ Enter language (e.g., English): ");
        scanner.nextLine(); // Consume newline left-over
        String language = scanner.nextLine();

        System.out.print("💰 Enter minimum budget (or press Enter for no minimum): ");
        String minBudgetInput = scanner.nextLine();
        BigDecimal minBudget = minBudgetInput.isEmpty() ? null : new BigDecimal(minBudgetInput);

        System.out.print("💰 Enter maximum budget (or press Enter for no maximum): ");
        String maxBudgetInput = scanner.nextLine();
        BigDecimal maxBudget = maxBudgetInput.isEmpty() ? null : new BigDecimal(maxBudgetInput);

        int pageSize = 2;
        int currentPage = 0;

        System.out.println("🔍 Searching for movies with your criteria...");

        while (true) {
            List<MovieDTO> movies = movieService.findMoviesByCriteria(minRating, language, minBudget, maxBudget, currentPage, pageSize);

            if (movies.isEmpty()) {
                if (currentPage == 0) {
                    System.out.println("❌ No movies found matching your criteria!");
                }
                break; // Exit the loop if no more movies are found
            }

            System.out.println("🍿 Page " + (currentPage + 1) + ":");
            movies.forEach(movie -> {
                System.out.println("--------------------------------------------------");
                System.out.println("🎥 Movie ID: " + movie.getMovieId());
                System.out.println("📖 Title: " + movie.getTitle());
                System.out.println("📅 Year Released: " + movie.getYearReleased());
                System.out.println("🎬 Director: " + movie.getDirectorName());
                System.out.println("🗣️ Language: " + movie.getLanguage());
                System.out.println("⭐ Rating: " + movie.getRating());
                System.out.println("💰 Budget: $" + movie.getBudget());
                System.out.println("--------------------------------------------------");
            });

            currentPage++; // Move to the next page
        }

        System.out.println("✅ Finished displaying all movies!");

        scanner.close();
    }
}
