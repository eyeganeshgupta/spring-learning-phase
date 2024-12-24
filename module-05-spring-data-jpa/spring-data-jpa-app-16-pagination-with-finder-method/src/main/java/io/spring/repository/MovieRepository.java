package io.spring.repository;

import io.spring.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Page<Movie> findAllByYearReleasedGreaterThanEqual(int yearReleased, Pageable pageable);
}
