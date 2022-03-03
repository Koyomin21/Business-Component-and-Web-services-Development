package kz.iitu.itse1909r.nugmanova.Database;

import lombok.Data;
import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "Author")
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorId", nullable = false)
    private Integer authorId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Transient
    private String fullName = getName() + " " + getSurname();

    @Column(name = "dob", nullable = false)
    private LocalDate dob;

    @Column(name = "awarded", nullable = false)
    private Boolean awarded;



    @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
    @OrderBy("rank asc, price asc")
    private List<Book> books;

    public Author(){}
    public Author(String name, String surname, LocalDate dob, Boolean awarded) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.awarded = awarded;
    }

    @Override
    public String toString() {
        return "AUTHOR NAME: " + this.name + " " + this.surname;
    }
}
