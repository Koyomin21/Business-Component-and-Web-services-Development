package kz.iitu.itse1909.borangaziyev.database;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;

@Entity
@Inheritance
public class User {
    @Id
    private long id;
}
