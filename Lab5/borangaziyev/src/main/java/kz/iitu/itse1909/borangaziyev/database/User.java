package kz.iitu.itse1909.borangaziyev.database;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
@Inheritance
@Table(name="Users")
public class User {
    @Id
    private long id;
}
