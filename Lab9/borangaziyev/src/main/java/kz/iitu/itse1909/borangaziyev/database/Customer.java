package kz.iitu.itse1909.borangaziyev.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.core.annotation.Order;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotNull
    @Column(name = "firstName")
    @Size(min = 2, max = 50)
    private String firstName;

    @NotNull
    @Column(name = "lastName")
    @Size(min = 2, max = 50)
    private String lastName;

    @Transient
    @JsonIgnore
    private String fullName = this.firstName + " " + this.lastName;

    @NotNull
    @LastModifiedDate
    @Column(name = "email")
    private String email;

    @NotNull
    @LastModifiedBy
    @Column(name = "isVip")
    private boolean isVip;

    @JsonIgnore
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


//    public boolean getIsVip() {
//        return isVip;
//    }
}
