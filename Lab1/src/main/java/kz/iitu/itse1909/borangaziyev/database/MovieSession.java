package kz.iitu.itse1909.borangaziyev.database;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "MovieSession")
public class MovieSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sessionId;

    @ManyToOne
    @JoinColumn(name = "movieId")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "hallId")
    private Hall hall;

    @Column(name = "price")
    private int price;

    @Column(name = "sessionDate")
    private LocalDate sessionDate;

    @Column(name = "startTime")
    private LocalTime startTime;

    @Column(name = "endTime")
    private LocalTime endTime;


    @OneToMany(mappedBy = "session")
    private List<Booking> bookings;


    public MovieSession(){}

//    public MovieSession(Movie movie, Hall hall, int price, LocalDate sessionDate, LocalTime start, LocalTime end) {
////        this.movie = movie;
//        this.hall = hall;
//        this.price = price;
//        this.sessionDate = sessionDate;
//        this.start = start;
//        this.end = end;
//
//    }

    @Override
    public String toString() {
        return "Session: " +
                "Movie: " + this.movie.getTitle() +
                "Session date: " + this.sessionDate +
                "Time: " + this.startTime + " - " + this.endTime;
    }
}
