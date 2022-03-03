package kz.iitu.itse1909r.nugmanova.Database;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "Customer")
@Component
public class Customer implements Serializable {
    @Id
    @Column(name = "customerId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Column(name = "email", nullable = false)
    private String email;

    @Value("${customer.password}")
    @Column(name = "password", nullable = false)
    private String password;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
    private List<Cart> carts;

    public Customer(){}
    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "CUSTOMER DATA: " + this.email + " " + this.password;
    }
}
