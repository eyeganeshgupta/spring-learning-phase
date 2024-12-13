package io.spring.repository;

import io.spring.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
    // 1. Find movies by multiple genres
    @Query("SELECT m FROM Movie m WHERE m.genre IN :genres")
    List<Movie> findByGenres(@Param("genres") List<String> genres);

    // 2. Find top N movies by rating in a specific genre
    @Query("SELECT m FROM Movie m WHERE m.genre = :genre ORDER BY m.rating DESC")
    List<Movie> findTopMoviesByGenre(@Param("genre") String genre, Pageable pageable);

    // 3. Find profitable movies
    @Query("SELECT m FROM Movie m WHERE m.boxOffice > m.budget")
    List<Movie> findProfitableMovies();

    // 4. Find movies with high ratings and box office earnings
    @Query("SELECT m FROM Movie m WHERE m.rating >= :rating AND m.boxOffice >= :boxOffice")
    List<Movie> findHighRatingAndBoxOfficeMovies(@Param("rating") double rating, @Param("boxOffice") double boxOffice);

    // 5. Paginated search for movies by title containing a keyword
    Page<Movie> findByTitleContaining(String keyword, Pageable pageable);

    // 6. Find movies released after a specific date
    @Query("SELECT m FROM Movie m WHERE m.releaseDate >= :date")
    List<Movie> findMoviesReleasedAfter(@Param("date") LocalDate date);

    // 7. Aggregate: Count movies by genre
    @Query("SELECT m.genre, COUNT(m) FROM Movie m GROUP BY m.genre")
    List<Object[]> countMoviesByGenre();

    // 8. Aggregate: Average rating of movies by genre
    @Query("SELECT m.genre, AVG(m.rating) FROM Movie m GROUP BY m.genre")
    List<Object[]> findAverageRatingByGenre();

    // 9. Aggregate: Maximum box office earnings by genre
    @Query("SELECT m.genre, MAX(m.boxOffice) FROM Movie m GROUP BY m.genre")
    List<Object[]> findMaxBoxOfficeByGenre();

    // 10. Aggregate: Minimum budget by genre
    @Query("SELECT m.genre, MIN(m.budget) FROM Movie m GROUP BY m.genre")
    List<Object[]> findMinBudgetByGenre();

    // 11. Aggregate: Total box office earnings by country
    @Query("SELECT m.country, SUM(m.boxOffice) FROM Movie m GROUP BY m.country")
    List<Object[]> sumBoxOfficeByCountry();

    // 12. Find longest movies by genre
    @Query("SELECT m FROM Movie m WHERE m.genre = :genre ORDER BY m.durationMinutes DESC")
    List<Movie> findLongestMoviesByGenre(@Param("genre") String genre, Pageable pageable);

    // 13. Find award-winning movies sorted by rating and release date
    @Query("SELECT m FROM Movie m WHERE LOWER(CAST(m.awards AS string)) LIKE LOWER(CONCAT('%', :keyword, '%')) ORDER BY m.rating DESC, m.releaseDate ASC")
    List<Movie> findAwardWinningMoviesSorted(@Param("keyword") String keyword);

    // 14. Find movies by director name, genre, and release year range
    @Query("SELECT m FROM Movie m WHERE " +
            "m.directorName = :directorName AND " +
            "m.genre = :genre AND " +
            "m.yearReleased BETWEEN :startYear AND :endYear")
    List<Movie> findMoviesByDirectorGenreAndYearRange(
            @Param("directorName") String directorName,
            @Param("genre") String genre,
            @Param("startYear") int startYear,
            @Param("endYear") int endYear
    );

    // 15. Check if any movie exists with a specific title and release year
    boolean existsByTitleAndYearReleased(String title, int yearReleased);

    // 16. Find the most profitable movie (highest box office minus budget)
    @Query("SELECT m FROM Movie m ORDER BY (m.boxOffice - m.budget) DESC")
    List<Movie> findMostProfitableMovie(Pageable pageable);
}
