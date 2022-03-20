package kz.iitu.itse1909.borangaziyev.database;


import kz.iitu.itse1909.borangaziyev.validators.CheckSeat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQuery(
        name = "Seat.findAllByHallName",
        query = "select s from Seat s where s.hall.name = :hallName"
)
@Data
@Entity
@Table(name = "Seat")
@CheckSeat
public class Seat implements Serializable {
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
