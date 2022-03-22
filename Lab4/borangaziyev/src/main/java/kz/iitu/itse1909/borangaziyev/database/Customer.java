package kz.iitu.itse1909.borangaziyev.database;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "isVip")
    private boolean isVip;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
    private List<Booking> bookings;

    @Override
    public String toString() {
        return "Customer: " +
                "ID: " + this.customerId + " " +
                "Email: " + this.email + " " +
                "First Name: " + this.firstName + " " +
                "Last Name: " + this.lastName + " " +
                "Is Vip: " + this.isVip;
    }
}
