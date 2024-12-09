package io.spring.repository;

import io.spring.entity.Movie;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
    // Find movies by director and genre
    List<Movie> findByDirectorNameAndGenre(String directorName, String genre);

    // Find movies by release year and rating greater than or equal to a specific value
    List<Movie> findByYearReleasedAndRatingGreaterThanEqual(int yearReleased, double rating);

    // Find movies by genre or language
    List<Movie> findByGenreOrLanguage(String genre, String language);

    // Find movies with a budget between two values
    List<Movie> findByBudgetBetween(double minBudget, double maxBudget);

    // Find movies released within a specific date range
    List<Movie> findByReleaseDateBetween(LocalDate startDate, LocalDate endDate);

    // Find top-rated movies in a specific genre (ordered by rating descending)
    List<Movie> findByGenreOrderByRatingDesc(String genre);

    // Find movies by title starting with a specific prefix (case-sensitive)
    List<Movie> findByTitleStartingWith(String prefix);

    // Find movies by title ending with a specific suffix (case-sensitive)
    List<Movie> findByTitleEndingWith(String suffix);

    // Find movies with a runtime greater than a specific duration
    List<Movie> findByDurationMinutesGreaterThan(int durationMinutes);

    // Find movies by awards containing a keyword and order them by release date ascending
    List<Movie> findByAwardsContainingOrderByReleaseDateAsc(String awardKeyword);

    // Count the number of movies in a specific language and genre
    long countByLanguageAndGenre(String language, String genre);

    // Check if any movie exists with a specific IMDb ID
    boolean existsByImdbId(String imdbId);

    // Find the first movie (by release date) in a specific genre
    Movie findFirstByGenreOrderByReleaseDateAsc(String genre);

    // Find the latest movie (by release date) in a specific language
    Movie findTopByLanguageOrderByReleaseDateDesc(String language);
}
