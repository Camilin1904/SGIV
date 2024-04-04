package co.edu.icesi.sgiv.domain;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "identification_number", nullable = false, unique = true, length = 50)
    private String identificationNumber;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "second_last_name", nullable = false, length = 100)
    private String secondLastName;

    @Column(name = "phone_1", nullable = false, length = 20)
    private String phone1;

    @Column(name = "phone_2", length = 20)
    private String phone2;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "gender", nullable = false, length = 10)
    private String gender;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

}
