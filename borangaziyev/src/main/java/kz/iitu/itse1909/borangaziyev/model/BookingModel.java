package kz.iitu.itse1909.borangaziyev.model;

import kz.iitu.itse1909.borangaziyev.database.Customer;
import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import kz.iitu.itse1909.borangaziyev.database.Seat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
public class BookingModel {

    private long bookingId;

    private LocalDate bookingDate;

    private boolean isPaid;

    private int customerId;

    private int sessionId;

    private int seatId;
}
