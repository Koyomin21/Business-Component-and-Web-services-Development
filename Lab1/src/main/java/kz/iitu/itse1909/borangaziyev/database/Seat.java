package kz.iitu.itse1909.borangaziyev.database;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seatId;

    @Column(name = "row")
    private int row;

    @Column(name = "number")
    private int number;

    @ManyToOne
    @JoinColumn(name="hallId")
    private Hall hall;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "seat")
    private List<Booking> bookings;

    @Override
    public String toString() {
        return "Seat: " +
                "Row: " + this.row + " " +
                "Number: " + this.number + " " +
                "Hall: " + this.hall.getName();
    }

}
