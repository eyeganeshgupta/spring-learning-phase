package io.spring.dto;

import java.math.BigDecimal;
import java.util.Date;

public class MovieDTO {
    private Integer movieId;
    private String title;
    private Integer yearReleased;
    private String directorName;
    private String genre;
    private Date releaseDate;
    private BigDecimal rating;
    private Integer durationMinutes;
    private String language;
    private String country;
    private BigDecimal budget;
    private BigDecimal boxOffice;
    private String synopsis;
    private String posterUrl;
    private String productionCompany;
    private String screenplayWriter;
    private String musicComposer;
    private String cinematographer;
    private String editor;
    private String awards;
    private String streamingPlatforms;
    private String cast;
    private String imdbId;
    private String mpaaRating;
    private String filmingLocations;

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(Integer yearReleased) {
        this.yearReleased = yearReleased;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget= budget;
    }

    public BigDecimal getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(BigDecimal boxOffice) {
        this.boxOffice= boxOffice;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis= synopsis;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl= posterUrl;
    }

    public String getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(String productionCompany) {
        this.productionCompany= productionCompany;
    }

    public String getScreenplayWriter() {
        return screenplayWriter;
    }

    public void setScreenplayWriter(String screenplayWriter) {
        this.screenplayWriter= screenplayWriter;
    }

    public String getMusicComposer() {
        return musicComposer;
    }

    public void setMusicComposer(String musicComposer) {
        this.musicComposer= musicComposer;
    }

    public String getCinematographer() {
        return cinematographer;
    }

    public void setCinematographer(String cinematographer) {
        this.cinematographer= cinematographer;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor= editor;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards= awards;
    }

    public String getStreamingPlatforms() {
        return streamingPlatforms;
    }

    public void setStreamingPlatforms(String streamingPlatforms) {
        this.streamingPlatforms= streamingPlatforms;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast= cast;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId= imdbId;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating= mpaaRating;
    }

    public String getFilmingLocations() {
        return filmingLocations;
    }

    public void setFilmingLocations(String filmingLocations) {
        this.filmingLocations= filmingLocations;
    }

    @Override
    public String toString() {
        return String.format(
                "*****************************\n" +
                        "* Movie Details             *\n" +
                        "*****************************\n" +
                        "ID: %d\n" +
                        "Title: %s\n" +
                        "Year Released: %d\n" +
                        "Director: %s\n" +
                        "Genre: %s\n" +
                        "Release Date: %s\n" +
                        "Rating: %.1f\n" +
                        "Duration: %d minutes\n" +
                        "Language: %s\n" +
                        "Country: %s\n" +
                        "Budget: $%,.2f\n" +
                        "Box Office: $%,.2f\n" +
                        "Synopsis: %s\n" +
                        "Poster URL: %s\n" +
                        "Production Company: %s\n" +
                        "Screenplay Writer: %s\n" +
                        "Music Composer: %s\n" +
                        "Cinematographer: %s\n" +
                        "Editor: %s\n" +
                        "Awards: %s\n" +
                        "Streaming Platforms: %s\n" +
                        "Cast: %s\n" +
                        "IMDB ID: %s\n" +
                        "MPAA Rating: %s\n" +
                        "Filming Locations: %s\n",
                movieId,
                title,
                yearReleased,
                directorName,
                genre,
                releaseDate != null ? releaseDate.toString() : "N/A",
                rating != null ? rating : BigDecimal.ZERO,
                durationMinutes,
                language,
                country,
                budget != null ? budget : BigDecimal.ZERO,
                boxOffice != null ? boxOffice : BigDecimal.ZERO,
                synopsis,
                posterUrl,
                productionCompany,
                screenplayWriter,
                musicComposer,
                cinematographer,
                editor,
                awards,
                streamingPlatforms,
                cast,
                imdbId,
                mpaaRating,
                filmingLocations
        );
    }
}
