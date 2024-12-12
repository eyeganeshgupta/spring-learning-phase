package io.spring.runner;

import io.spring.dto.MovieDTO;
import io.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class MovieRunner implements CommandLineRunner {

    @Autowired
    private MovieService movieService;

    @Override
    public void run(String... args) {
        System.out.println("\n=== Movies by Genres ===");
        List<MovieDTO> moviesByGenres = movieService.findByGenres(Arrays.asList("Action", "Drama"));
        moviesByGenres.forEach(System.out::println);

        System.out.println("\n=== Top 5 Movies by Rating in 'Action' Genre ===");
        List<MovieDTO> topMoviesByGenre = movieService.findTopMoviesByGenre("Action", 5);
        topMoviesByGenre.forEach(System.out::println);

        System.out.println("\n=== Profitable Movies ===");
        List<MovieDTO> profitableMovies = movieService.findProfitableMovies();
        profitableMovies.forEach(System.out::println);

        System.out.println("\n=== High Rating and Box Office Movies (Rating >= 8.0, Box Office >= 100M) ===");
        List<MovieDTO> highRatingMovies = movieService.findHighRatingAndBoxOfficeMovies(8.0, 100_000_000);
        highRatingMovies.forEach(System.out::println);

        System.out.println("\n=== Paginated Search for Movies with 'hero' in Title ===");
        Page<?> paginatedMovies = movieService.searchMoviesByTitle("hero", 0, 5);
        paginatedMovies.getContent().forEach(System.out::println);

        System.out.println("\n=== Movies Released After 2000-01-01 ===");
        List<MovieDTO> recentMovies = movieService.findMoviesReleasedAfter(LocalDate.of(2000, 1, 1));
        recentMovies.forEach(System.out::println);

        System.out.println("\n=== Count of Movies by Genre ===");
        movieService.countMoviesByGenre().forEach(row -> System.out.println(Arrays.toString(row)));

        System.out.println("\n=== Average Rating by Genre ===");
        movieService.findAverageRatingByGenre().forEach(row -> System.out.println(Arrays.toString(row)));

        System.out.println("\n=== Maximum Box Office by Genre ===");
        movieService.findMaxBoxOfficeByGenre().forEach(row -> System.out.println(Arrays.toString(row)));

        System.out.println("\n=== Minimum Budget by Genre ===");
        movieService.findMinBudgetByGenre().forEach(row -> System.out.println(Arrays.toString(row)));

        System.out.println("\n=== Total Box Office by Country ===");
        movieService.sumBoxOfficeByCountry().forEach(row -> System.out.println(Arrays.toString(row)));

        System.out.println("\n=== Longest Movies in 'Comedy' Genre ===");
        List<MovieDTO> longestMovies = movieService.findLongestMoviesByGenre("Comedy", 3);
        longestMovies.forEach(System.out::println);

        System.out.println("\n=== Award-Winning Movies with Keyword 'Oscar' ===");
        List<MovieDTO> awardWinningMovies = movieService.findAwardWinningMoviesSorted("Oscar");
        awardWinningMovies.forEach(System.out::println);

        System.out.println("\n=== Movies by Director, Genre, and Year Range ===");
        List<MovieDTO> moviesByDirectorAndGenre = movieService.findMoviesByDirectorGenreAndYearRange("Rajkumar Hirani", "Drama", 2000, 2020);
        moviesByDirectorAndGenre.forEach(System.out::println);

        System.out.println("\n=== Check if Movie Exists ===");
        boolean exists = movieService.checkMovieExists("3 Idiots", 2009);
        System.out.println("Does '3 Idiots' (2009) exist? " + exists);

        System.out.println("\n=== Most Profitable Movies ===");
        List<MovieDTO> mostProfitableMovies = movieService.findMostProfitableMovie(1);
        mostProfitableMovies.forEach(System.out::println);
    }
}
