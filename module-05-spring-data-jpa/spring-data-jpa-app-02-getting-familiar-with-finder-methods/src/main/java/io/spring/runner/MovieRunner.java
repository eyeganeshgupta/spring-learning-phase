package io.spring.runner;

import io.spring.dto.MovieDTO;
import io.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
        System.out.println("=== Starting Movie Service Operations ===");

        performMovieOperations();

        System.out.println("=== Movie Service Operations Completed ===");
    }

    private void performMovieOperations() {
        findMovieByTitle("Inception");
        countMoviesByGenre("Science Fiction");
        findMoviesByDirector("Christopher Nolan");
        findMoviesByGenre("Drama");
        findMoviesReleasedInYear(2008);
        findMoviesWithHighRating(8.0);
        findMoviesWithTitleKeyword("Dark");
        findMoviesOnStreamingPlatform("Netflix");
        findMoviesWithLowBudget(50_000_000);
        findMoviesInLanguage("English");
        findAwardWinningMovies("Oscar");
        findRecentMovies(LocalDate.of(2010, 1, 1));
    }

    private void findMovieByTitle(String title) {
        System.out.println("\n--- Finding Movie By Title ---");
        MovieDTO movie = movieService.findByTitle(title);
        if (movie != null) {
            System.out.println("Movie Found: " + movie);
        } else {
            System.out.println("No movie found with title: " + title);
        }
    }

    private void countMoviesByGenre(String genre) {
        System.out.println("\n--- Counting Movies By Genre ---");
        long count = movieService.countByGenre(genre);
        System.out.println("Number of movies in genre '" + genre + "': " + count);
    }

    private void findMoviesByDirector(String directorName) {
        System.out.println("\n--- Finding Movies By Director ---");
        List<MovieDTO> movies = movieService.findByDirectorName(directorName);
        printMovieList(movies, "Movies directed by " + directorName);
    }

    private void findMoviesByGenre(String genre) {
        System.out.println("\n--- Finding Movies By Genre ---");
        List<MovieDTO> movies = movieService.findByGenre(genre);
        printMovieList(movies, "Movies in genre '" + genre + "'");
    }

    private void findMoviesReleasedInYear(int year) {
        System.out.println("\n--- Finding Movies Released In Year ---");
        List<MovieDTO> movies = movieService.findByYearReleased(year);
        printMovieList(movies, "Movies released in year " + year);
    }

    private void findMoviesWithHighRating(double rating) {
        System.out.println("\n--- Finding Movies With High Rating ---");
        List<MovieDTO> movies = movieService.findByRatingGreaterThanEqual(rating);
        printMovieList(movies, "Movies with rating >= " + rating);
    }

    private void findMoviesWithTitleKeyword(String keyword) {
        System.out.println("\n--- Finding Movies With Title Containing Keyword ---");
        List<MovieDTO> movies = movieService.findByTitleContaining(keyword);
        printMovieList(movies, "Movies containing '" + keyword + "' in their title");
    }

    private void findMoviesOnStreamingPlatform(String platform) {
        System.out.println("\n--- Finding Movies Available On Streaming Platform ---");
        List<MovieDTO> movies = movieService.findByStreamingPlatformsContaining(platform);
        printMovieList(movies, "Movies available on '" + platform + "'");
    }

    private void findMoviesWithLowBudget(double budget) {
        System.out.println("\n--- Finding Low Budget Movies ---");
        List<MovieDTO> movies = movieService.findByBudgetLessThan(budget);
        printMovieList(movies, "Movies with budget < " + budget);
    }

    private void findMoviesInLanguage(String language) {
        System.out.println("\n--- Finding Movies In Specific Language ---");
        List<MovieDTO> movies = movieService.findByLanguage(language);
        printMovieList(movies, "Movies in language '" + language + "'");
    }

    private void findAwardWinningMovies(String awardKeyword) {
        System.out.println("\n--- Finding Award-Winning Movies ---");
        List<MovieDTO> movies = movieService.findByAwardsContaining(awardKeyword);
        printMovieList(movies, "Award-winning movies containing '" + awardKeyword + "'");
    }

    private void findRecentMovies(LocalDate releaseDate) {
        System.out.println("\n--- Finding Recent Movies Released After Specific Date ---");
        List<MovieDTO> movies = movieService.findByReleaseDateAfter(releaseDate);
        printMovieList(movies, "Movies released after " + releaseDate);
    }

    /**
     * Utility method to print movie lists or show a message when the list is empty.
     */
    private void printMovieList(List<MovieDTO> movies, String description) {
        if (!movies.isEmpty()) {
            System.out.println(description + ":");
            movies.forEach(System.out::println);
        } else {
            System.out.println("No movies found for: " + description);
        }
    }
}
