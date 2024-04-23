package co.edu.icesi.sgiv.domain.entity;

import co.edu.icesi.sgiv.domain.modification.ClientModification;
import co.edu.icesi.sgiv.domain.status.ClientStatus;
import co.edu.icesi.sgiv.domain.type.IdentificationType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@Table(name = "client")
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

    @ManyToOne
    @JoinColumn(name = "creator_user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private ClientStatus status;

    @ManyToOne
    @JoinColumn(name = "identification_type_id", nullable = false)
    private IdentificationType identificationType;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ClientModification> modifications;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Plan> requestedPlans;

    public Client(String identificationNumber, String firstName, String lastName, String secondLastName, String phone1, String phone2, String email, String gender, Date birthDate, Date creationDate, User user, ClientStatus status) {
        this.identificationNumber = identificationNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;
        this.gender = gender;
        this.birthDate = birthDate;
        this.creationDate = creationDate;
        this.user = user;
        this.status = status;
    }
}