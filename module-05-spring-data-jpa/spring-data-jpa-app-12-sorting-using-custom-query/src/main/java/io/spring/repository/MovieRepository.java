package io.spring.repository;

import io.spring.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query(value = "SELECT m from Movie m WHERE m.directorName like '%:directorName%' order by m.yearReleased")
    List<Movie> findByDirectorNameContainingOrderByYearReleased(@Param("directorName") String directorName);
}
