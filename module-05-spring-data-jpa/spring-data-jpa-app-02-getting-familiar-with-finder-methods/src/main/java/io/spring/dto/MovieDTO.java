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
        StringBuilder builder = new StringBuilder();
        builder.append("\n*****************************\n")
                .append("* Movie Details             *\n")
                .append("*****************************\n")
                .append("ID: ").append(movieId != null ? movieId : "N/A").append("\n")
                .append("Title: ").append(title != null ? title : "N/A").append("\n")
                .append("Year Released: ").append(yearReleased != null ? yearReleased : "N/A").append("\n")
                .append("Director: ").append(directorName != null ? directorName : "N/A").append("\n")
                .append("Genre: ").append(genre != null ? genre : "N/A").append("\n")
                .append("Release Date: ").append(releaseDate != null ? releaseDate.toString() : "N/A").append("\n")
                .append("Rating: ").append(rating != null ? String.format("%.1f", rating) : "N/A").append("\n")
                .append("Duration: ").append(durationMinutes != null ? durationMinutes + " minutes" : "N/A").append("\n")
                .append("Language: ").append(language != null ? language : "N/A").append("\n")
                .append("Country: ").append(country != null ? country : "N/A").append("\n")
                .append("Budget: ").append(budget != null ? String.format("$%,.2f", budget) : "N/A").append("\n")
                .append("Box Office: ").append(boxOffice != null ? String.format("$%,.2f", boxOffice) : "N/A").append("\n")
                .append("Synopsis: ").append(synopsis != null ? synopsis : "N/A").append("\n")
                .append("Poster URL: ").append(posterUrl != null ? posterUrl : "N/A").append("\n")
                .append("Production Company: ").append(productionCompany != null ? productionCompany : "N/A").append("\n")
                .append("Screenplay Writer: ").append(screenplayWriter != null ? screenplayWriter : "N/A").append("\n")
                .append("Music Composer: ").append(musicComposer != null ? musicComposer : "N/A").append("\n")
                .append("Cinematographer: ").append(cinematographer != null ? cinematographer : "N/A").append("\n")
                .append("Editor: ").append(editor != null ? editor : "N/A").append("\n")
                .append("Awards: ").append(awards != null ? awards : "N/A").append("\n")
                .append("Streaming Platforms: ").append(streamingPlatforms != null ? streamingPlatforms : "N/A").append("\n")
                .append("Cast: ").append(cast != null ? cast : "N/A").append("\n")
                .append("IMDB ID: ").append(imdbId != null ? imdbId : "N/A").append("\n")
                .append("MPAA Rating: ").append(mpaaRating != null ? mpaaRating : "N/A").append("\n")
                .append("Filming Locations: ").append(filmingLocations != null ? filmingLocations : "N/A").append("\n");

        return builder.toString();
    }
}
