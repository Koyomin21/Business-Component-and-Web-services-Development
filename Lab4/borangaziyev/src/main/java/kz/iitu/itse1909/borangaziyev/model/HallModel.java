package kz.iitu.itse1909.borangaziyev.model;

import lombok.Data;

import javax.persistence.Column;

@Data
public class HallModel {
    private long hallId;

    private String name;

    private int capacity;
}
