package kz.iitu.itse1909.borangaziyev.model;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class MovieModel implements Serializable {
    private long movieId;

    private int minutes;

    private int publishedYear;

    private String title;

    private String description;

    public  MovieModel() {}
    public MovieModel(int minutes, int publishedYear, String title, String description) {
        this.minutes = minutes;
        this.publishedYear = publishedYear;
        this.title = title;
        this.description = description;
    }


    @Override
    public String toString() {
        return "Movie: " +
                "ID: " + this.movieId + "\n" +
                "Title: " + this.title + "\n" +
                "Minutes: " + this.minutes + "\n" +
                "Published Year: " + this.publishedYear + "\n" +
                "Description: " + this.description + "\n";

    }
}
