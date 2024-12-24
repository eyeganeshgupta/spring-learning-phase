package io.spring.repository;

import io.spring.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query("SELECT m FROM Movie m " +
            "WHERE m.rating >= :minRating " +
            "AND m.language = :language " +
            "AND (:minBudget IS NULL OR m.budget >= :minBudget) " +
            "AND (:maxBudget IS NULL OR m.budget <= :maxBudget)")
    Page<Movie> findMoviesByRatingAndLanguageAndBudget(
            @Param("minRating") BigDecimal minRating,
            @Param("language") String language,
            @Param("minBudget") BigDecimal minBudget,
            @Param("maxBudget") BigDecimal maxBudget,
            Pageable pageable
    );
}
