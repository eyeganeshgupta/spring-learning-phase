package io.spring.service;

import io.spring.projection.BasicMovieDetail;
import io.spring.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<BasicMovieDetail> getMoviesByRating(BigDecimal rating, Sort sort) {
        return movieRepository.findByRatingGreaterThan(rating, sort);
    }
}
