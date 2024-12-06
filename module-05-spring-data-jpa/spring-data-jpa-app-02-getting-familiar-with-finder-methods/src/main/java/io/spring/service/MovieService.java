package io.spring.service;

import io.spring.entity.Movie;
import io.spring.repository.MovieRepository;
import io.spring.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Convert Movie entity to MovieDTO
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

    // Convert MovieDTO to Movie entity
    private Movie convertToEntity(MovieDTO dto) {
        Movie movie = new Movie();
        movie.setMovieId(dto.getMovieId());
        movie.setTitle(dto.getTitle());
        movie.setYearReleased(dto.getYearReleased());
        movie.setDirectorName(dto.getDirectorName());
        movie.setGenre(dto.getGenre());
        movie.setReleaseDate(dto.getReleaseDate());
        movie.setRating(dto.getRating());
        movie.setDurationMinutes(dto.getDurationMinutes());
        movie.setLanguage(dto.getLanguage());
        movie.setCountry(dto.getCountry());
        movie.setBudget(dto.getBudget());
        movie.setBoxOffice(dto.getBoxOffice());
        movie.setSynopsis(dto.getSynopsis());
        movie.setPosterUrl(dto.getPosterUrl());
        movie.setProductionCompany(dto.getProductionCompany());
        movie.setScreenplayWriter(dto.getScreenplayWriter());
        movie.setMusicComposer(dto.getMusicComposer());
        movie.setCinematographer(dto.getCinematographer());
        movie.setEditor(dto.getEditor());
        movie.setAwards(dto.getAwards());
        movie.setStreamingPlatforms(dto.getStreamingPlatforms());
        movie.setCast(dto.getCast());
        movie.setImdbId(dto.getImdbId());
        movie.setMpaaRating(dto.getMpaaRating());
        movie.setFilmingLocations(dto.getFilmingLocations());
        return movie;
    }

    // Find movie by title
    public MovieDTO findByTitle(String title) {
        return convertToDTO(movieRepository.findByTitle(title));
    }

    // Count movies by genre
    public long countByGenre(String genre) {
        return movieRepository.countByGenre(genre);
    }

    // Find movies by director's name
    public List<MovieDTO> findByDirectorName(String directorName) {
        return movieRepository.findByDirectorName(directorName)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Find movies by genre
    public List<MovieDTO> findByGenre(String genre) {
        return movieRepository.findByGenre(genre)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Find movies released in a specific year
    public List<MovieDTO> findByYearReleased(int yearReleased) {
        return movieRepository.findByYearReleased(yearReleased)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Find movies with a rating greater than or equal to a specific value
    public List<MovieDTO> findByRatingGreaterThanEqual(double rating) {
        return movieRepository.findByRatingGreaterThanEqual(rating)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Find movies with a title containing a specific keyword
    public List<MovieDTO> findByTitleContaining(String keyword) {
        return movieRepository.findByTitleContaining(keyword)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Find movies available on a specific streaming platform
    public List<MovieDTO> findByStreamingPlatformsContaining(String platform) {
        return movieRepository.findByStreamingPlatformsContaining(platform)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Find movies with a budget less than a specified amount
    public List<MovieDTO> findByBudgetLessThan(double budget) {
        return movieRepository.findByBudgetLessThan(budget)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Find movies in a specific language
    public List<MovieDTO> findByLanguage(String language) {
        return movieRepository.findByLanguage(language)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Find movies that have won specific awards
    public List<MovieDTO> findByAwardsContaining(String awardKeyword) {
        return movieRepository.findByAwardsContaining(awardKeyword)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Find movies released after a specific date
    public List<MovieDTO> findByReleaseDateAfter(LocalDate releaseDate) {
        return movieRepository.findByReleaseDateAfter(releaseDate)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
