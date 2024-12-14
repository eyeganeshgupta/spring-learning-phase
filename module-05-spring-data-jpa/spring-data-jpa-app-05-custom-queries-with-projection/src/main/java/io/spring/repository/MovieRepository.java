package io.spring.repository;

import io.spring.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    // Projection query to fetch only title and rating
    @Query("SELECT m.title AS title, m.rating AS rating FROM Movie m WHERE m.rating > :minRating")
    List<MovieProjection> findMoviesWithRatingAbove(@Param("minRating") double minRating);
}
