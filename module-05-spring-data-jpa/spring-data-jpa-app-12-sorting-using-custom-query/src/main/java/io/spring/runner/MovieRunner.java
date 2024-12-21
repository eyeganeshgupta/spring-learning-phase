package io.spring;

import io.spring.projection.BasicMovieDetail;
import io.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
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
        // Defining a minimum rating and sorting criteria
        BigDecimal minRating = new BigDecimal("7.5");
        /* Sort sortV1 = Sort.by(Sort.Direction.DESC, "title", "yearReleased"); */
        Sort sortV2 = Sort.by(Sort.Order.desc("title"), Sort.Order.asc("yearReleased"));

        // Fetching movies with a rating greater than 7.5, sorted by title (desc) and year (asc)
        List<BasicMovieDetail> movies = movieService.getMoviesByRating(minRating, sortV2);

        // Printing the results
        System.out.println("\n==============================");
        System.out.println("🎥 Movies with Rating > " + minRating);
        System.out.println("==============================\n");

        if (movies.isEmpty()) {
            System.out.println("No movies found matching the criteria.\n");
        } else {
            int count = 1;
            for (BasicMovieDetail movie : movies) {
                System.out.printf(
                        "%d. 🎬 **%s** (%d)\n" +
                                "   - Genre: %s\n" +
                                "   - Rating: ⭐ %.1f\n" +
                                "------------------------------\n",
                        count++,
                        movie.getTitle(),
                        movie.getYearReleased(),
                        movie.getGenre(),
                        movie.getRating()
                );
            }
        }
    }
}
