package io.spring.runner;

import io.spring.dto.MovieDTO;
import io.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Component
public class MovieRunner implements CommandLineRunner {

    private final MovieService movieService;

    @Autowired
    public MovieRunner(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void run(String... args) throws Exception {
        MovieDTO newMovie = new MovieDTO();
        newMovie.setTitle("The Dark Knight");
        newMovie.setYearReleased(2008);
        newMovie.setDirectorName("Christopher Nolan");
        newMovie.setGenre("Action, Crime, Drama");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        newMovie.setReleaseDate(dateFormat.parse("2008-07-18"));

        newMovie.setRating(new BigDecimal("9.0"));
        newMovie.setDurationMinutes(152);
        newMovie.setLanguage("English");
        newMovie.setCountry("USA");
        newMovie.setBudget(new BigDecimal("185000000.00"));
        newMovie.setBoxOffice(new BigDecimal("1004558444.00"));
        newMovie.setSynopsis("When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham. The Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        newMovie.setPosterUrl("https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_.jpg");
        newMovie.setProductionCompany("Warner Bros., Legendary Entertainment, Syncopy");
        newMovie.setScreenplayWriter("Jonathan Nolan, Christopher Nolan");
        newMovie.setMusicComposer("Hans Zimmer, James Newton Howard");
        newMovie.setCinematographer("Wally Pfister");
        newMovie.setEditor("Lee Smith");
        newMovie.setAwards("Won 2 Oscars. Another 157 wins & 163 nominations.");
        newMovie.setStreamingPlatforms("HBO Max, Amazon Prime Video");
        newMovie.setCast("Christian Bale, Heath Ledger, Aaron Eckhart");
        newMovie.setImdbId("tt0468569");
        newMovie.setMpaaRating("PG-13");
        newMovie.setFilmingLocations("Chicago, Illinois, USA");

        // Save the movie DTO
        MovieDTO savedMovie = movieService.saveMovie(newMovie);
        System.out.println("Saved Movie: " + savedMovie);
    }
}
