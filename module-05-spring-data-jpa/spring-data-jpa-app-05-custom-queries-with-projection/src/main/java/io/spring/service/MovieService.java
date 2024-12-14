package io.spring.service;

import io.spring.dto.MovieDTO;
import io.spring.entity.Movie;
import io.spring.repository.MovieProjection;
import io.spring.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Save a new movie
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Get movies with ratings above a certain value using projection
    public List<MovieProjection> getMoviesWithHighRatings(double minRating) {
        return movieRepository.findMoviesWithRatingAbove(minRating);
    }
}
