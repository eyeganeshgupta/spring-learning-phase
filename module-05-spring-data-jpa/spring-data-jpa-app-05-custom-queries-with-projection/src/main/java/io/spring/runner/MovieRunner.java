package io.spring.runner;

import io.spring.repository.BasicMovieInfoProjection;
import io.spring.repository.FinancialInfoProjection;
import io.spring.repository.StreamingInfoProjection;
import io.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MovieRunner implements CommandLineRunner {
    private final MovieService movieService;

    @Autowired
    public MovieRunner(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\nMovies with Ratings Above 8.0:");
        movieService.getMoviesWithHighRatings(8.0).forEach(projection ->
                System.out.println(projection.getTitle() + " - Rating: " + projection.getRating())
        );

        System.out.println("\nBasic Movie Information:");
        for (BasicMovieInfoProjection info : movieService.getBasicMovieInfo()) {
            System.out.println("Title: " + info.getTitle() + ", Director: " + info.getDirectorName() + ", Year: " + info.getYearReleased());
        }

        System.out.println("\nFinancial Information:");
        for (FinancialInfoProjection financial : movieService.getFinancialInfo()) {
            System.out.println("Budget: $" + financial.getBudget() + ", Box Office: $" + financial.getBoxOffice());
        }

        System.out.println("\nStreaming Platforms:");
        for (StreamingInfoProjection streaming : movieService.getStreamingInfo()) {
            System.out.println("Title: " + streaming.getTitle() + ", Platforms: " + streaming.getStreamingPlatforms());
        }
    }
}
