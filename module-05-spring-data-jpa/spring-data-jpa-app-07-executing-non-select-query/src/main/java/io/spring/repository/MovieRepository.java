package io.spring.repository;

import io.spring.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    // Update the rating of a movie by its ID
    @Modifying
    @Transactional
    @Query(value = "UPDATE movies SET rating = :rating WHERE movie_id = :movieId", nativeQuery = true)
    int updateMovieRating(@Param("movieId") Integer movieId, @Param("rating") BigDecimal rating);

    // Delete a movie by its title
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM movies WHERE title = :title", nativeQuery = true)
    int deleteMovieByTitle(@Param("title") String title);

    // Insert a new movie (Note: This is typically handled by saving an entity, but shown here for demonstration)
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO movies (title, year_released, director_name, genre, release_date, rating) " +
            "VALUES (:title, :yearReleased, :directorName, :genre, :releaseDate, :rating)", nativeQuery = true)
    int insertMovie(@Param("title") String title,
                    @Param("yearReleased") Integer yearReleased,
                    @Param("directorName") String directorName,
                    @Param("genre") String genre,
                    @Param("releaseDate") Date releaseDate,
                    @Param("rating") BigDecimal rating);
}
