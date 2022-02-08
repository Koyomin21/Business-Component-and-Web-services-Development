package kz.iitu.itse1909.borangaziyev.database;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movieId;

    @Column(name = "minutes")
    private int minutes;

    @Column(name = "publishedYear")
    private int publishedYear;

    @Column(name = "title")
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "movie")
    private List<MovieSession> sessions;


    public Movie() {}

    public Movie(String title, int minutes, int publishedYear, String description) {
        this.title = title;
        this.minutes = minutes;
        this.publishedYear = publishedYear;
        this.description = description;
    }

    public void movieInit() {
        System.out.println("Init method of Movie");

    }

    public void movieDestroy() {
        System.out.println("Init method of destroy");
    }

    @Override
    public String toString() {
        return "Movie: " +
                "ID: " + this.movieId + " " +
                "Title: " + this.title + " " +
                "Minutes: " + this.minutes + " " +
                "Published Year: " + this.publishedYear + " " +
                "Description: " + this.description;

    }

}
