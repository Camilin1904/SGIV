package co.edu.icesi.sgiv.domain;


import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "user")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @Column(name = "creator_user", nullable = false, length = 50)
    private String creatorUser;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;
}