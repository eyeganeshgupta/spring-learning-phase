package io.spring.repository;

import io.spring.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query(value = "SELECT * FROM movies WHERE title = :title", nativeQuery = true)
    List<Movie> findMoviesByTitle(@Param("title") String title);

    @Query(value = "SELECT * FROM movies WHERE rating >= :rating", nativeQuery = true)
    List<Movie> findMoviesByMinimumRating(@Param("rating") BigDecimal rating);
}
