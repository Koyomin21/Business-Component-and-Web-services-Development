package kz.iitu.itse1909.borangaziyev.database;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;


    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "sessionId")
    private MovieSession session;

    @ManyToOne
    @JoinColumn(name = "seatId")
    private Seat seat;

    @Column(name = "bookingDate")
    private LocalDate bookingDate;

    @Column(name = "isPaid")
    private boolean isPaid;

    public Booking() {}


//    public Booking(Customer customer, MovieSession session, Seat seat) {
//        this.customer = customer;
//        this.session = session;
//        this.seat = seat;
//    }

    @Override
    public String toString() {
        return "Booking: " +
                "ID: " + this.bookingId + " " +
                "Customer: " + this.customer.getFirstName() + " " + this.customer.getLastName()+" " +
                "Session: " + this.session.getStartTime() + " " + this.session.getEndTime() +
                "Seat: " + this.seat + " " +
                "Is Paid: " + this.isPaid;
    }

}
