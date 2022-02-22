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

}
