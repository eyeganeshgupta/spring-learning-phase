package io.spring.runner;

import io.spring.dto.MovieDTO;
import io.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieRunner implements CommandLineRunner {
    private final MovieService movieService;

    @Autowired
    public MovieRunner(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Movies directed by 'Nolan' (ordered by year released):");
        List<MovieDTO> nolanMovies = movieService.getMoviesByDirectorName("Nolan");
        nolanMovies.forEach(System.out::println);

        // Example: Fetch movies by director name with dynamic sorting (e.g., by year_released)
        System.out.println("\nMovies directed by 'Nolan' (sorted by year_released):");
        List<MovieDTO> cNolanMovies = movieService.getMoviesByDirectorNameSorted(
                "Nolan", Sort.by(Sort.Direction.ASC, "yearReleased"));
        cNolanMovies.forEach(System.out::println);
    }
}
