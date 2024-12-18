package io.spring.runner;

import io.spring.dto.MovieDTO;
import io.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
        // Initialize date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Count initial number of movies
        long initialCount = movieService.countMovies();
        System.out.println("Initial number of movies: " + initialCount);

        // Create and save Titanic movie
        MovieDTO titanic = createTitanicMovie(dateFormat);
        MovieDTO savedMovie = movieService.saveMovie(titanic);
        System.out.println("Saved Movie: " + savedMovie);

        // Create and save Dark Knight Trilogy movies
        List<MovieDTO> darkKnightTrilogy = createDarkKnightTrilogy(dateFormat);
        List<MovieDTO> savedMovies = movieService.saveAllMovies(darkKnightTrilogy);
        System.out.println("Saved Movies: ");
        savedMovies.forEach(System.out::println);

        // Retrieve and print all movies
        List<MovieDTO> movies = movieService.getAllMovies();
        movies.forEach(System.out::println);

        // Retrieve a specific movie by ID
        retrieveAndPrintMovieById(1);

        // Delete a specific movie by ID
        deleteMovieById(1);

        // Delete multiple movies by IDs
        List<Integer> idsToDelete = Arrays.asList(2, 3, 4);
        movieService.deleteMoviesByIds(idsToDelete);

        // Delete all movies
        movieService.deleteAllMovies();

        // Count final number of movies after deletion
        long finalCount = movieService.countMovies();
        System.out.println("Number of movies after deletion: " + finalCount);
    }

    private MovieDTO createTitanicMovie(SimpleDateFormat dateFormat) throws Exception {
        MovieDTO titanic = new MovieDTO();
        titanic.setTitle("Titanic");
        titanic.setYearReleased(1997);
        titanic.setDirectorName("James Cameron");
        titanic.setGenre("Drama, Romance");
        titanic.setReleaseDate(dateFormat.parse("1997-12-19"));
        titanic.setRating(new BigDecimal("7.9"));
        titanic.setDurationMinutes(195);
        titanic.setLanguage("English");
        titanic.setCountry("USA");
        titanic.setBudget(new BigDecimal("200000000"));
        titanic.setBoxOffice(new BigDecimal("2201647264"));
        titanic.setSynopsis("A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious ill-fated R.M.S. Titanic.");
        titanic.setPosterUrl("https://m.media-amazon.com/images/M/MV5BYzYyN2FiZmUtYWYzMy00MzViLWJkZTMtOGY1ZjgzNWMwN2YxXkEyXkFqcGc@._V1_.jpg");
        titanic.setProductionCompany("20th Century Fox, Paramount Pictures, Lightstorm Entertainment");
        titanic.setScreenplayWriter("James Cameron");
        titanic.setMusicComposer("James Horner");
        titanic.setCinematographer("Russell Carpenter");
        titanic.setEditor("Conrad Buff IV, James Cameron, Richard A. Harris");
        titanic.setAwards("Won 11 Oscars.");
        titanic.setStreamingPlatforms("Disney+, Amazon Prime Video");
        titanic.setCast("Leonardo DiCaprio, Kate Winslet");
        titanic.setImdbId("tt0120338");
        titanic.setMpaaRating("PG-13");
        titanic.setFilmingLocations("Nova Scotia, Canada");

        return titanic;
    }

    private List<MovieDTO> createDarkKnightTrilogy(SimpleDateFormat dateFormat) throws Exception {
        MovieDTO batmanBegins = new MovieDTO();
        batmanBegins.setTitle("Batman Begins");
        batmanBegins.setYearReleased(2005);
        batmanBegins.setDirectorName("Christopher Nolan");
        batmanBegins.setGenre("Action, Adventure");
        batmanBegins.setReleaseDate(dateFormat.parse("2005-06-15"));
        batmanBegins.setRating(new BigDecimal("8.2"));
        batmanBegins.setDurationMinutes(140);
        batmanBegins.setLanguage("English");
        batmanBegins.setCountry("USA");
        batmanBegins.setBudget(new BigDecimal("150000000"));
        batmanBegins.setBoxOffice(new BigDecimal("373710015"));
        batmanBegins.setSynopsis("After training with his mentor, Batman begins his fight to free crime-ridden Gotham City from corruption.");
        batmanBegins.setPosterUrl("https://m.media-amazon.com/images/M/MV5BNDU2MzkyMzMtMDdkMy00Y2MzLTliMGYtMjQxYTcyNTIzMGY2XkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg");
        batmanBegins.setProductionCompany("Warner Bros., Legendary Entertainment, Syncopy");
        batmanBegins.setScreenplayWriter("Christopher Nolan, David S. Goyer");
        batmanBegins.setMusicComposer("Hans Zimmer, James Newton Howard");
        batmanBegins.setCinematographer("Wally Pfister");
        batmanBegins.setEditor("Lee Smith");
        batmanBegins.setAwards("Nominated for 1 Oscar.");
        batmanBegins.setStreamingPlatforms("HBO Max, Amazon Prime Video");
        batmanBegins.setCast("Christian Bale, Michael Caine, Liam Neeson");
        batmanBegins.setImdbId("tt0372784");
        batmanBegins.setMpaaRating("PG-13");
        batmanBegins.setFilmingLocations("Chicago, Illinois, USA");

        MovieDTO darkKnight = new MovieDTO();
        darkKnight.setTitle("The Dark Knight");
        darkKnight.setYearReleased(2008);
        darkKnight.setDirectorName("Christopher Nolan");
        darkKnight.setGenre("Action, Crime, Drama");
        darkKnight.setReleaseDate(dateFormat.parse("2008-07-18"));
        darkKnight.setRating(new BigDecimal("9.0"));
        darkKnight.setDurationMinutes(152);
        darkKnight.setLanguage("English");
        darkKnight.setCountry("USA");
        darkKnight.setBudget(new BigDecimal("185000000"));
        darkKnight.setBoxOffice(new BigDecimal("1004558444"));
        darkKnight.setSynopsis("When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.");
        darkKnight.setPosterUrl("https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_FMjpg_UX1000_.jpg");
        darkKnight.setProductionCompany("Warner Bros., Legendary Entertainment, Syncopy");
        darkKnight.setScreenplayWriter("Jonathan Nolan, Christopher Nolan");
        darkKnight.setMusicComposer("Hans Zimmer, James Newton Howard");
        darkKnight.setCinematographer("Wally Pfister");
        darkKnight.setEditor("Lee Smith");
        darkKnight.setAwards("Won 2 Oscars.");
        darkKnight.setStreamingPlatforms("HBO Max, Amazon Prime Video");
        darkKnight.setCast("Christian Bale, Heath Ledger, Aaron Eckhart");
        darkKnight.setImdbId("tt0468569");
        darkKnight.setMpaaRating("PG-13");
        darkKnight.setFilmingLocations("Chicago, Illinois, USA");

        MovieDTO darkKnightRises = new MovieDTO();
        darkKnightRises.setTitle("The Dark Knight Rises");
        darkKnightRises.setYearReleased(2012);
        darkKnightRises.setDirectorName("Christopher Nolan");
        darkKnightRises.setGenre("Action, Adventure");
        darkKnightRises.setReleaseDate(dateFormat.parse("2012-07-20"));
        darkKnightRises.setRating(new BigDecimal("8.4"));
        darkKnightRises.setDurationMinutes(164);
        darkKnightRises.setLanguage("English");
        darkKnightRises.setCountry("USA");
        darkKnightRises.setBudget(new BigDecimal("250000000"));
        darkKnightRises.setBoxOffice(new BigDecimal("1081041287"));
        darkKnightRises.setSynopsis("Eight years after the Joker's reign of anarchy, Batman is forced from his exile to save Gotham City from the brutal guerrilla terrorist Bane.");
        darkKnightRises.setPosterUrl("https://m.media-amazon.com/images/M/MV5BMTk4ODQzNDY3Ml5BMl5BanBnXkFtZTcwODA0NTM4Nw@@._V1_FMjpg_UX1000_.jpg");
        darkKnightRises.setProductionCompany("Warner Bros., Legendary Entertainment, Syncopy");
        darkKnightRises.setScreenplayWriter("Jonathan Nolan, Christopher Nolan");
        darkKnightRises.setMusicComposer("Hans Zimmer");
        darkKnightRises.setCinematographer("Wally Pfister");
        darkKnightRises.setEditor("Lee Smith");
        darkKnightRises.setAwards("Nominated for 1 Oscar.");
        darkKnightRises.setStreamingPlatforms("HBO Max");
        darkKnightRises.setCast("Christian Bale, Tom Hardy, Anne Hathaway");
        darkKnightRises.setImdbId("tt1345836");
        darkKnightRises.setMpaaRating("PG-13");
        darkKnightRises.setFilmingLocations("Pittsburgh, Pennsylvania, USA");

        return Arrays.asList(batmanBegins, darkKnight, darkKnightRises);
    }

    private void retrieveAndPrintMovieById(Integer id) {
        Optional<MovieDTO> retrievedMovie = movieService.getMovieById(id);
        if (retrievedMovie.isPresent()) {
            System.out.println(retrievedMovie.get());
        } else {
            System.out.println("Movie with ID " + id + " not found.");
        }
    }

    private void deleteMovieById(Integer id) {
        boolean isDeleted = movieService.deleteMovieById(id);
        if (isDeleted) {
            System.out.println("Movie with ID " + id + " successfully deleted.");
        } else {
            System.out.println("Movie with ID " + id + " could not be deleted.");
        }
    }
}
