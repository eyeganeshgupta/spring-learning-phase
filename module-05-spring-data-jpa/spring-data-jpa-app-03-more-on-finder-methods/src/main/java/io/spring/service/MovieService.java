package io.spring.service;

import io.spring.dto.MovieDTO;
import io.spring.entity.Movie;
import io.spring.repository.MovieRepository;
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

        return movie;
    }

    // Find movies by director and genre
    public List<MovieDTO> findByDirectorAndGenre(String directorName, String genre) {
        return movieRepository.findByDirectorNameAndGenre(directorName, genre)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Find movies by release year and rating greater than a specific value
    public List<MovieDTO> findByYearAndRating(int yearReleased, double rating) {
        return movieRepository.findByYearReleasedAndRatingGreaterThanEqual(yearReleased, rating)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Find movies by genre or language
    public List<MovieDTO> findByGenreOrLanguage(String genre, String language) {
        return movieRepository.findByGenreOrLanguage(genre, language)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Find movies with a budget between two values
    public List<MovieDTO> findByBudgetRange(double minBudget, double maxBudget) {
        return movieRepository.findByBudgetBetween(minBudget, maxBudget)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Find movies released within a specific date range
    public List<MovieDTO> findByReleaseDateRange(LocalDate startDate, LocalDate endDate) {
        return movieRepository.findByReleaseDateBetween(startDate, endDate)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Find top-rated movies in a specific genre
    public List<MovieDTO> findTopRatedMoviesInGenre(String genre) {
        return movieRepository.findByGenreOrderByRatingDesc(genre)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Find movies by title starting with a specific prefix
    public List<MovieDTO> findMoviesByTitleStartingWith(String prefix) {
        return movieRepository.findByTitleStartingWith(prefix)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Find movies by title ending with a specific suffix
    public List<MovieDTO> findMoviesByTitleEndingWith(String suffix) {
        return movieRepository.findByTitleEndingWith(suffix)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Find movies with a runtime greater than a specific duration
    public List<MovieDTO> findMoviesWithLongRuntime(int durationMinutes) {
        return movieRepository.findByDurationMinutesGreaterThan(durationMinutes)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Find award-winning movies ordered by release date
    public List<MovieDTO> findAwardWinningMoviesOrdered(String awardKeyword) {
        return movieRepository.findByAwardsContainingOrderByReleaseDateAsc(awardKeyword)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Count movies in a specific language and genre
    public long countMoviesInLanguageAndGenre(String language, String genre) {
        return movieRepository.countByLanguageAndGenre(language, genre);
    }

    // Check if a movie exists with a specific IMDb ID
    public boolean existsWithImdbId(String imdbId) {
        return movieRepository.existsByImdbId(imdbId);
    }

    // Find the first movie in a genre by release date
    public MovieDTO findFirstMovieInGenre(String genre) {
        return convertToDTO(movieRepository.findFirstByGenreOrderByReleaseDateAsc(genre));
    }

    // Find the latest movie in a specific language
    public MovieDTO findLatestMovieInLanguage(String language) {
        return convertToDTO(movieRepository.findTopByLanguageOrderByReleaseDateDesc(language));
    }
}
