package io.spring.service;

import io.spring.dto.MovieDTO;
import io.spring.entity.Movie;
import io.spring.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * Fetches movies based on rating, language, and budget range, with pagination.
     *
     * @param minRating Minimum rating of the movie.
     * @param language  Language of the movie.
     * @param minBudget Minimum budget (nullable).
     * @param maxBudget Maximum budget (nullable).
     * @param page      Page number (zero-based).
     * @param size      Number of movies per page.
     * @return A list of MovieDTO objects.
     */
    public List<MovieDTO> findMoviesByCriteria(BigDecimal minRating, String language, BigDecimal minBudget, BigDecimal maxBudget, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("rating"));
        Page<Movie> moviePage = movieRepository.findMoviesByRatingAndLanguageAndBudget(minRating, language, minBudget, maxBudget, pageable);
        return moviePage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private MovieDTO convertToDTO(Movie movie) {
        MovieDTO dto = new MovieDTO();
        dto.setMovieId(movie.getMovieId());
        dto.setTitle(movie.getTitle());
        dto.setYearReleased(movie.getYearReleased());
        dto.setDirectorName(movie.getDirectorName());
        dto.setGenre(movie.getGenre());
        dto.setReleaseDate(movie.getReleaseDate());
        dto.setRating(movie.getRating());
        dto.setDurationMinutes(movie.getDurationMinutes());
        dto.setLanguage(movie.getLanguage());
        dto.setCountry(movie.getCountry());
        dto.setBudget(movie.getBudget());
        dto.setBoxOffice(movie.getBoxOffice());
        dto.setSynopsis(movie.getSynopsis());
        dto.setPosterUrl(movie.getPosterUrl());
        dto.setProductionCompany(movie.getProductionCompany());
        dto.setScreenplayWriter(movie.getScreenplayWriter());
        dto.setMusicComposer(movie.getMusicComposer());
        dto.setCinematographer(movie.getCinematographer());
        dto.setEditor(movie.getEditor());
        dto.setAwards(movie.getAwards());
        dto.setStreamingPlatforms(movie.getStreamingPlatforms());
        dto.setCast(movie.getCast());
        dto.setImdbId(movie.getImdbId());
        dto.setMpaaRating(movie.getMpaaRating());
        dto.setFilmingLocations(movie.getFilmingLocations());
        return dto;
    }
}
