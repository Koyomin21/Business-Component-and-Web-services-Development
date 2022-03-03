package kz.iitu.itse1909r.nugmanova.Database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "Book")
public class Book implements Serializable {

    @PostConstruct
    public void initSession() {
        System.out.println("Initializing Session Bean with the post-construct method...");
        if(year == null) {year = 2022;}
        if(price == null) {price = 1000;}
        if (rank == null) {rank = 1.0;}
        System.out.println("Bean has been initialized!");
    }

    @PreDestroy
    public void destroySession() {
        System.out.println("Deleting Session Bean with the pre-destroy method...");
        if(this.name != null) {
            System.out.println("Session for the book '" + this.name + "' has been destroyed!");
        }
    }

    @Id
    @Column(name = "bookId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @Column(name = "name", nullable = false)
    private String name;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "authorId")
    private Author author;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "rank", nullable = false)
    private Double rank;

    @Lob
    @Column(name = "cover", nullable = true, columnDefinition = "bytea")
    private byte[]cover;

    @ManyToMany(mappedBy = "books")
    private List<Cart> carts;

    @Override
    public String toString() {
        return "BOOK NAME: " + this.name;
    }

    public Book(){}
    public Book(String name, Author author, Integer year, Integer price, String genre, String description, Double rank) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.price = price;
        this.genre = genre;
        this.description = description;
        this.rank = rank;
    }
}
