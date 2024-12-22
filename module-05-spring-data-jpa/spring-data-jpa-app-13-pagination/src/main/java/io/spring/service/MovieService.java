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

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDTO> findAll() {
        Pageable pageable = PageRequest.of(0, 3);
        Page<Movie> moviesPage = movieRepository.findAll(pageable);
        List<Movie> movies = moviesPage.getContent();
        return movies.stream().map(this::convertToDTO).collect(Collectors.toList());
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
