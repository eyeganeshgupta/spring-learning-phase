package io.spring.repository;

import io.spring.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query("SELECT m.title AS title, m.rating AS rating FROM Movie m WHERE m.rating > :minRating")
    List<MovieProjection> findMoviesWithRatingAbove(@Param("minRating") double minRating);

    @Query("SELECT m.title AS title, m.directorName AS directorName, m.yearReleased AS yearReleased FROM Movie m")
    List<BasicMovieInfoProjection> findAllBasicMovieInfo();

    @Query("SELECT m.budget AS budget, m.boxOffice AS boxOffice FROM Movie m")
    List<FinancialInfoProjection> findAllFinancialInfo();

    @Query("SELECT m.title AS title, m.streamingPlatforms AS streamingPlatforms FROM Movie m")
    List<StreamingInfoProjection> findAllStreamingInfo();
}
