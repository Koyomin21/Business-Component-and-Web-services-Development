package kz.iitu.itse1909.borangaziyev.model;

import kz.iitu.itse1909.borangaziyev.database.Hall;
import lombok.Data;

import javax.persistence.*;

@Data
public class SeatModel {

    private long seatId;

    private int row;

    private int number;

    private int hallId;
}
