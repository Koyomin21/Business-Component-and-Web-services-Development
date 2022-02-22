package kz.iitu.itse1909.borangaziyev.model;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class CustomerModel implements Serializable {
    private long customerId;

    private String firstName;

    private String lastName;

    private String email;

    private boolean isVip;
}
