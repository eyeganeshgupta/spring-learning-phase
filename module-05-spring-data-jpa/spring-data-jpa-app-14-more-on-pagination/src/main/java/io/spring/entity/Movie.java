package io.spring.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "year_released")
    private Integer yearReleased;

    @Column(name = "director_name", length = 255)
    private String directorName;

    @Column(name = "genre", length = 100)
    private String genre;

    @Temporal(TemporalType.DATE)
    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "rating", precision = 3, scale = 1)
    private BigDecimal rating;

    @Column(name = "duration_minutes")
    private Integer durationMinutes;

    @Column(name = "language", length = 50)
    private String language;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "budget", precision = 15, scale = 2)
    private BigDecimal budget;

    @Column(name = "box_office", precision = 15, scale = 2)
    private BigDecimal boxOffice;

    @Lob
    @Column(name = "synopsis")
    private String synopsis;

    @Column(name = "poster_url", length = 255)
    private String posterUrl;

    @Column(name = "production_company", length = 255)
    private String productionCompany;

    @Column(name = "screenplay_writer", length = 255)
    private String screenplayWriter;

    @Column(name = "music_composer", length = 255)
    private String musicComposer;

    @Column(name = "cinematographer", length = 255)
    private String cinematographer;

    @Column(name = "editor", length = 255)
    private String editor;

    @Lob
    @Column(name = "awards")
    private String awards;

    @Column(name = "streaming_platforms", length = 255)
    private String streamingPlatforms;

    @Lob
    @Column(name = "cast")
    private String cast;

    @Column(name= "imdb_id",length=20)
    private String imdbId;

    @Column(name= "mpaa_rating",length=10)
    private String mpaaRating;

    @Lob
    @Column(name= "filming_locations")
    private String filmingLocations;

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId= movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title= sanitizeString(title,255);
    }

    public Integer getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(Integer yearReleased) {
        if (yearReleased != null && yearReleased > 1800 && yearReleased <= new Date().getYear() + 1900) {
            this.yearReleased= yearReleased;
        } else {
            throw new IllegalArgumentException("Invalid year released");
        }
    }

    public String getDirectorName() {
        return directorName;

    }

    public void setDirectorName(String directorName) {
        this.directorName= sanitizeString(directorName,255);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre= sanitizeString(genre,100);
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        if (releaseDate != null && releaseDate.before(new Date())) {
            this.releaseDate= releaseDate;
        } else {
            throw new IllegalArgumentException("Invalid release date");
        }
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        if (rating != null && rating.compareTo(BigDecimal.ZERO) >= 0 && rating.compareTo(new BigDecimal("10.0")) <= 0) {
            this.rating= rating;
        } else {
            throw new IllegalArgumentException("Invalid rating");
        }

    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        if (durationMinutes != null && durationMinutes > 0) {
            this.durationMinutes= durationMinutes;
        } else {
            throw new IllegalArgumentException("Invalid duration");
        }
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language= sanitizeString(language,50);
    }

    public String getCountry() {
        return country;

    }

    public void setCountry(String country) {
        this.country= sanitizeString(country,100);
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        if (budget != null && budget.compareTo(BigDecimal.ZERO) >= 0) {
            this.budget= budget;
        } else {
            throw new IllegalArgumentException("Invalid budget");
        }
    }

    public BigDecimal getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(BigDecimal boxOffice) {
        if (boxOffice != null && boxOffice.compareTo(BigDecimal.ZERO) >= 0) {
            this.boxOffice= boxOffice;
        } else {
            throw new IllegalArgumentException("Invalid box office");
        }

    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis= synopsis!= null ? synopsis.trim(): null;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl= sanitizeString(posterUrl,255);
    }

    public String getProductionCompany() {
        return productionCompany;

    }

    public void setProductionCompany(String productionCompany) {
        this.productionCompany= sanitizeString(productionCompany,255);
    }

    public String getScreenplayWriter() {
        return screenplayWriter;
    }

    public void setScreenplayWriter(String screenplayWriter) {
        this.screenplayWriter= sanitizeString(screenplayWriter,255);
    }

    public String getMusicComposer() {
        return musicComposer;
    }

    public void setMusicComposer(String musicComposer) {
        this.musicComposer= sanitizeString(musicComposer,255);
    }

    public String getCinematographer() {
        return cinematographer;
    }

    public void setCinematographer(String cinematographer) {
        this.cinematographer= sanitizeString(cinematographer,255);
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor= sanitizeString(editor,255);
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards= awards!= null ? awards.trim(): null;
    }

    public String getStreamingPlatforms() {
        return streamingPlatforms;
    }

    public void setStreamingPlatforms(String streamingPlatforms) {
        this.streamingPlatforms= sanitizeString(streamingPlatforms,255);
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast= cast!= null ? cast.trim(): null;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId= sanitizeString(imdbId,20);
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating= sanitizeString(mpaaRating,10);
    }

    public String getFilmingLocations() {
        return filmingLocations;
    }

    public void setFilmingLocations(String filmingLocations) {
        this.filmingLocations= filmingLocations!= null ? filmingLocations.trim(): null;
    }

    private static String sanitizeString(String value, int maxLength) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        value=value.trim();
        if (value.length()> maxLength){
            value=value.substring(0,maxLength);
        }
        return value;

    }
}
