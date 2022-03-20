package kz.iitu.itse1909.borangaziyev.database;
import lombok.Data;
import org.springframework.context.annotation.Lazy;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@NamedQuery(
        name = "Session.findAllByMovieTitle",
        query = "select s from MovieSession s where s.movie.title = :title"
)
@Data
@Entity
@Table(name = "MovieSession")
@Lazy
public class MovieSession implements Serializable {

    @PostConstruct
    public void initSession() {
        System.out.println("Initializing Session bean(postconstruct)");
        if(sessionDate == null) {
            sessionDate = LocalDate.of(2022, 06, 01);
        }

        if(startTime == null || endTime == null) {
            startTime = LocalTime.of(15,0);
            endTime = LocalTime.of(16,0);
        }
    }

    @PreDestroy
    public void destroySession() {
        System.out.println("Destroying Session");
        if(this.movie != null) {
            System.out.println("Session of movie: " + this.movie.getTitle() + "  was Destroyed");
        }

    }

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
    @Max(100000)
    private int price;

    @Column(name = "sessionDate")
    private LocalDate sessionDate;

    @Column(name = "startTime")
    private LocalTime startTime;

    @Column(name = "endTime")
    private LocalTime endTime;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "session")
    private List<Booking> bookings;


    public MovieSession(){}

    public MovieSession(Hall hall, int price, LocalDate sessionDate, LocalTime startTime, LocalTime endTime) {
        this.hall = hall;
        this.price = price;
        this.sessionDate = sessionDate;
        this.startTime = startTime;
        this.endTime = endTime;

    }

    @Override
    public String toString() {
        return "Session: " +
                "Movie: " + this.movie.getTitle() + " " +
                "Session date: " + this.sessionDate + " " +
                "Time: " + this.startTime + " - " + this.endTime;
    }
}
