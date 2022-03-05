package kz.iitu.itse1909.borangaziyev.database;

import lombok.Data;
import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQuery(
        name = "Customer.findAllNotVipCustomers",
        query = "select c from Customer c where c.isVip = false"
)
@Data
@Entity
@Table(name = "Customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Transient
    private String fullName = firstName + " " + lastName;

    @Column(name = "version")
    @Version
    private int version;

    @Column(name = "email")
    private String email;

    @Column(name = "isVip")
    private boolean isVip;

    @Lob
    @Column(name = "avatar", columnDefinition = "BYTEA", nullable = true)
    private byte[]photo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
    @OrderBy("bookingDate ASC, isPaid")
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
