package io.spring.service;

import io.spring.dto.MovieDTO;
import io.spring.entity.Movie;
import io.spring.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

    public MovieDTO saveMovie(MovieDTO movieDTO) {
        Movie movie = convertToEntity(movieDTO);
        Movie savedMovie = movieRepository.save(movie);
        return convertToDTO(savedMovie);
    }

    public List<MovieDTO> saveAllMovies(List<MovieDTO> movieDTOs) {
        List<Movie> movies = movieDTOs.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());

        List<Movie> savedMovies = (List<Movie>) movieRepository.saveAll(movies);

        return savedMovies.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = (List<Movie>) movieRepository.findAll();

        // Check for empty result
        if (movies.isEmpty()) {
            return Collections.emptyList(); // Return an empty list if no movies found
        }

        // Convert each Movie entity to a MovieDTO
        return movies.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<MovieDTO> getMovieById(Integer id) {
        return movieRepository.findById(id).map(movie -> convertToDTO(movie));
    }

    public boolean deleteMovieById(Integer id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        }
        return false;
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

    private Movie convertToEntity(MovieDTO movieDTO) {
        Movie movie= new Movie();
        movie.setMovieId(movieDTO.getMovieId());
        movie.setTitle(movieDTO.getTitle());
        movie.setYearReleased(movieDTO.getYearReleased());
        movie.setDirectorName(movieDTO.getDirectorName());
        movie.setGenre(movieDTO.getGenre());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setRating(movieDTO.getRating());
        movie.setDurationMinutes(movieDTO.getDurationMinutes());
        movie.setLanguage(movieDTO.getLanguage());
        movie.setCountry(movieDTO.getCountry());
        movie.setBudget(movieDTO.getBudget());
        movie.setBoxOffice(movieDTO.getBoxOffice());
        movie.setSynopsis(movieDTO.getSynopsis());
        movie.setPosterUrl(movieDTO.getPosterUrl());
        movie.setProductionCompany(movieDTO.getProductionCompany());
        movie.setScreenplayWriter(movieDTO.getScreenplayWriter());
        movie.setMusicComposer(movieDTO.getMusicComposer());
        movie.setCinematographer(movieDTO.getCinematographer());
        movie.setEditor(movieDTO.getEditor());
        movie.setAwards(movieDTO.getAwards());
        movie.setStreamingPlatforms(movieDTO.getStreamingPlatforms());
        movie.setCast(movieDTO.getCast());
        movie.setImdbId(movieDTO.getImdbId());
        movie.setMpaaRating(movieDTO.getMpaaRating());
        movie.setFilmingLocations( movieDTO. getFilmingLocations());

        return movie;
    }
}
