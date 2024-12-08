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
        // Find movies by director and genre
        List<MovieDTO> directorAndGenreMovies = movieService.findByDirectorAndGenre("Sanjay Leela Bhansali", "Drama");
        System.out.println("Movies by director and genre: " + directorAndGenreMovies);

        // Find movies by year and rating
        List<MovieDTO> yearAndRatingMovies = movieService.findByYearAndRating(2023, 8.0);
        System.out.println("Movies by year and rating: " + yearAndRatingMovies);

        // Find movies by genre or language
        List<MovieDTO> genreOrLanguageMovies = movieService.findByGenreOrLanguage("Action", "Hindi");
        System.out.println("Movies by genre or language: " + genreOrLanguageMovies);

        // Find movies with budget between two values
        List<MovieDTO> budgetRangeMovies = movieService.findByBudgetRange(5000000, 10000000);
        System.out.println("Movies by budget range: " + budgetRangeMovies);

        // Find movies released within a specific date range
        List<MovieDTO> releaseDateRangeMovies = movieService.findByReleaseDateRange(LocalDate.of(2020, 1, 1), LocalDate.of(2024, 12, 31));
        System.out.println("Movies by release date range: " + releaseDateRangeMovies);

        // Find top-rated movies in a specific genre
        List<MovieDTO> topRatedGenreMovies = movieService.findTopRatedMoviesInGenre("Thriller");
        System.out.println("Top-rated movies in genre: " + topRatedGenreMovies);

        // Find movies by title starting with a specific prefix
        List<MovieDTO> titleStartingWithMovies = movieService.findMoviesByTitleStartingWith("The");
        System.out.println("Movies by title starting with: " + titleStartingWithMovies);

        // Find movies by title ending with a specific suffix
        List<MovieDTO> titleEndingWithMovies = movieService.findMoviesByTitleEndingWith("Saga");
        System.out.println("Movies by title ending with: " + titleEndingWithMovies);

        // Find movies with runtime greater than a specific duration
        List<MovieDTO> longRuntimeMovies = movieService.findMoviesWithLongRuntime(150);
        System.out.println("Movies with long runtime: " + longRuntimeMovies);

        // Find award-winning movies ordered by release date
        List<MovieDTO> awardWinningMovies = movieService.findAwardWinningMoviesOrdered("Oscar");
        System.out.println("Award-winning movies: " + awardWinningMovies);

        // Count movies in a specific language and genre
        long countMovies = movieService.countMoviesInLanguageAndGenre("Hindi", "Romance");
        System.out.println("Count of movies in language and genre: " + countMovies);

        // Check if a movie exists with a specific IMDb ID
        boolean exists = movieService.existsWithImdbId("tt1234567");
        System.out.println("Exists with IMDb ID: " + exists);

        // Find the first movie in a genre by release date
        MovieDTO firstMovieInGenre = movieService.findFirstMovieInGenre("Comedy");
        System.out.println("First movie in genre: " + firstMovieInGenre);

        // Find the latest movie in a specific language
        MovieDTO latestMovieInLanguage = movieService.findLatestMovieInLanguage("English");
        System.out.println("Latest movie in language: " + latestMovieInLanguage);
    }
}
