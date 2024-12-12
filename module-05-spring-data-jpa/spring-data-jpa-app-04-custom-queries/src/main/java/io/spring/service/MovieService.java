package io.spring.service;

import io.spring.entity.Movie;
import io.spring.dto.MovieDTO;
import io.spring.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public List<MovieDTO> findByGenres(List<String> genres) {
        return movieRepository.findByGenres(genres).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<MovieDTO> findTopMoviesByGenre(String genre, int topN) {
        return movieRepository.findTopMoviesByGenre(genre, PageRequest.of(0, topN)).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<MovieDTO> findProfitableMovies() {
        return movieRepository.findProfitableMovies().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<MovieDTO> findHighRatingAndBoxOfficeMovies(double rating, double boxOffice) {
        return movieRepository.findHighRatingAndBoxOfficeMovies(rating, boxOffice).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Page<Movie> searchMoviesByTitle(String keyword, int page, int size) {
        return movieRepository.findByTitleContaining(keyword, PageRequest.of(page, size));
    }

    public List<MovieDTO> findMoviesReleasedAfter(LocalDate date) {
        return movieRepository.findMoviesReleasedAfter(date).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<Object[]> countMoviesByGenre() {
        return movieRepository.countMoviesByGenre();
    }

    public List<Object[]> findAverageRatingByGenre() {
        return movieRepository.findAverageRatingByGenre();
    }

    public List<Object[]> findMaxBoxOfficeByGenre() {
        return movieRepository.findMaxBoxOfficeByGenre();
    }

    public List<Object[]> findMinBudgetByGenre() {
        return movieRepository.findMinBudgetByGenre();
    }

    public List<Object[]> sumBoxOfficeByCountry() {
        return movieRepository.sumBoxOfficeByCountry();
    }

    public List<MovieDTO> findLongestMoviesByGenre(String genre, int topN) {
        return movieRepository.findLongestMoviesByGenre(genre, PageRequest.of(0, topN)).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<MovieDTO> findAwardWinningMoviesSorted(String keyword) {
        return movieRepository.findAwardWinningMoviesSorted(keyword).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<MovieDTO> findMoviesByDirectorGenreAndYearRange(String directorName, String genre, int startYear, int endYear) {
        return movieRepository.findMoviesByDirectorGenreAndYearRange(directorName, genre, startYear, endYear).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public boolean checkMovieExists(String title, int yearReleased) {
        return movieRepository.existsByTitleAndYearReleased(title, yearReleased);
    }

    public List<MovieDTO> findMostProfitableMovie(int topN) {
        return movieRepository.findMostProfitableMovie(PageRequest.of(0, topN)).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Convert Movie entity to MovieDTO
    private MovieDTO convertToDTO(Movie movie) {
        if (movie == null) {
            return null;
        }
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
