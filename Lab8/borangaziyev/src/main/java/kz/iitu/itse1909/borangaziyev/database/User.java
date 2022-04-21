package kz.iitu.itse1909.borangaziyev.database;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="Users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String roleName;


    private int failedLoginAttempts;
    private boolean loginDisabled;
    private boolean accountVerified;
}
