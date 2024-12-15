package io.spring.service;

import io.spring.dto.MovieDTO;
import io.spring.entity.Movie;
import io.spring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieProjection> getMoviesWithHighRatings(double minRating) {
        return movieRepository.findMoviesWithRatingAbove(minRating);
    }

    public List<BasicMovieInfoProjection> getBasicMovieInfo() {
        return movieRepository.findAllBasicMovieInfo();
    }

    public List<FinancialInfoProjection> getFinancialInfo() {
        return movieRepository.findAllFinancialInfo();
    }

    public List<StreamingInfoProjection> getStreamingInfo() {
        return movieRepository.findAllStreamingInfo();
    }
}
