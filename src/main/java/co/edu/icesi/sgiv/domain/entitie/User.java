package co.edu.icesi.sgiv.domain.entitie;


import co.edu.icesi.sgiv.domain.modification.ClientModification;
import co.edu.icesi.sgiv.domain.modification.DestinationModification;
import co.edu.icesi.sgiv.domain.modification.PlanDetailModification;
import co.edu.icesi.sgiv.domain.modification.PlanModification;
import co.edu.icesi.sgiv.domain.status.ClientStatus;
import co.edu.icesi.sgiv.domain.status.UserStatus;
import co.edu.icesi.sgiv.domain.type.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
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

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private UserStatus status;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private UserType type;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Destination> createdClients;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Destination> createdPlanDetails;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Destination> createdDestinations;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Plan> createdPlans;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ClientModification> clientModifications;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<DestinationModification> destinationModifications;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PlanModification> planModifications;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PlanDetailModification> planDetailModifications;


}