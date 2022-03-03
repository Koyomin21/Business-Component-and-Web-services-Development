package kz.iitu.itse1909r.nugmanova.Database;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "Cart")
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartId", nullable = false)
    private Integer cartId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CartItem", joinColumns = { @JoinColumn(name = "bookId")},
            inverseJoinColumns = {@JoinColumn(name = "cartId")})
    private List<Book> books;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToOne(mappedBy = "cart")
    private Order order;

    public Cart(){}
}
