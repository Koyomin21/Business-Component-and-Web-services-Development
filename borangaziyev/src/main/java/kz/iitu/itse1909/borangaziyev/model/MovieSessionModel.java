package kz.iitu.itse1909.borangaziyev.model;

import kz.iitu.itse1909.borangaziyev.database.Hall;
import kz.iitu.itse1909.borangaziyev.database.Movie;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class MovieSessionModel {

    private long sessionId;

    private int movieId;

    private int hallId;

    private int price;

    private LocalDate sessionDate;

    private LocalTime startTime;

    private LocalTime endTime;
}

