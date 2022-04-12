package kz.iitu.itse1909.borangaziyev.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;


@NamedQuery(
        name = "Booking.findPaidBookings",
        query = "select b from Booking b where b.isPaid = true"
)
@Data
@Entity
@Table(name = "Booking")
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;

    @CreatedBy
    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sessionId")
    private MovieSession session;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "seatId")
    private Seat seat;

    @CreatedDate
    @Column(name = "bookingDate")
    private LocalDate bookingDate;

    @Column(name = "isPaid")
    @NotNull
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
                "Session: " + this.session.getStartTime() + " " + this.session.getEndTime() + " " +
                "Seat: Row: " + this.seat.getRow() + ", Number: " + this.seat.getNumber() + " " +
                "Is Paid: " + this.isPaid;
    }

}
