package kz.iitu.itse1909r.nugmanova.Database;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Users")
@Inheritance
public class User {

    @Id
    private int userId;

    @Column(name = "name", nullable = false)
    protected String name;

    @Column(name = "surname", nullable = false)
    protected String surname;
}
