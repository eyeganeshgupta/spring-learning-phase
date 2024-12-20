package io.spring.repository;

import io.spring.entity.Movie;
import io.spring.projection.BasicMovieDetail;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<BasicMovieDetail> findByRatingGreaterThan(BigDecimal rating, Sort sort);
}
