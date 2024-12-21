package io.spring.projection;

import java.math.BigDecimal;

public interface BasicMovieDetail {
    Integer getMovieId();
    String getTitle();
    Integer getYearReleased();
    String getGenre();
    BigDecimal getRating();
}
