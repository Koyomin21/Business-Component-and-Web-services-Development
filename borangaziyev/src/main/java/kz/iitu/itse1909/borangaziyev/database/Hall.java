package kz.iitu.itse1909.borangaziyev.database;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Hall")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hallId;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private int capacity;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "hall")
    private List<MovieSession> sessions;

    @OneToMany(mappedBy = "hall")
    private List<Seat> seats;

}
