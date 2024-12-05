package io.spring.repository;

import io.spring.entity.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
    // Find movie by its title
    Movie findByTitle(String title);

    // Count total number of movies having the Genre which is provided.
    long countByGenre(String genre);

    // Find movies by director's name
    List<Movie> findByDirectorName(String directorName);

    // Find movies by genre
    List<Movie> findByGenre(String genre);

    // Find movies released in a specific year
    List<Movie> findByYearReleased(int yearReleased);

    // Find movies with a rating greater than or equal to a specific value
    List<Movie> findByRatingGreaterThanEqual(double rating);

    // Find movies with a title containing a specific keyword (case-sensitive)
    List<Movie> findByTitleContaining(String keyword);

    // Find movies available on a specific streaming platform
    List<Movie> findByStreamingPlatformsContaining(String platform);

    // Find movies with a budget less than a specified amount
    List<Movie> findByBudgetLessThan(double budget);

    // Find movies in a specific language
    List<Movie> findByLanguage(String language);

    // Find movies that have won specific awards
    List<Movie> findByAwardsContaining(String awardKeyword);

    // Find movies released after a specific date
    List<Movie> findByReleaseDateAfter(java.time.LocalDate releaseDate);
}
