package kz.iitu.itse1909r.nugmanova.Database;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId", nullable = false)
    private Integer orderId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cartId")
    private Cart cart;


    @Version
    @Transient
    @Column(name = "version", columnDefinition = "integer default 0")
    private int version;

    @Column(name = "orderDate", nullable = false)
    private LocalDate orderDate;

    public Order(){}
}
