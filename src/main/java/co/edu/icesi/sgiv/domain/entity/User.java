package co.edu.icesi.sgiv.domain.entity;


import co.edu.icesi.sgiv.domain.modification.ClientModification;
import co.edu.icesi.sgiv.domain.modification.DestinationModification;
import co.edu.icesi.sgiv.domain.modification.PlanDetailModification;
import co.edu.icesi.sgiv.domain.modification.PlanModification;
import co.edu.icesi.sgiv.domain.status.UserStatus;
import co.edu.icesi.sgiv.domain.type.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

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
    private List<Client> createdClients;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PlanDetail> createdPlanDetails;

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

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public List<Client> getCreatedClients() {
        return createdClients;
    }

    public void setCreatedClients(List<Client> createdClients) {
        this.createdClients = createdClients;
    }

    public List<PlanDetail> getCreatedPlanDetails() {
        return createdPlanDetails;
    }

    public void setCreatedPlanDetails(List<PlanDetail> createdPlanDetails) {
        this.createdPlanDetails = createdPlanDetails;
    }

    public List<Destination> getCreatedDestinations() {
        return createdDestinations;
    }

    public void setCreatedDestinations(List<Destination> createdDestinations) {
        this.createdDestinations = createdDestinations;
    }

    public List<Plan> getCreatedPlans() {
        return createdPlans;
    }

    public void setCreatedPlans(List<Plan> createdPlans) {
        this.createdPlans = createdPlans;
    }

    public List<ClientModification> getClientModifications() {
        return clientModifications;
    }

    public void setClientModifications(List<ClientModification> clientModifications) {
        this.clientModifications = clientModifications;
    }

    public List<DestinationModification> getDestinationModifications() {
        return destinationModifications;
    }

    public void setDestinationModifications(List<DestinationModification> destinationModifications) {
        this.destinationModifications = destinationModifications;
    }

    public List<PlanModification> getPlanModifications() {
        return planModifications;
    }

    public void setPlanModifications(List<PlanModification> planModifications) {
        this.planModifications = planModifications;
    }

    public List<PlanDetailModification> getPlanDetailModifications() {
        return planDetailModifications;
    }

    public void setPlanDetailModifications(List<PlanDetailModification> planDetailModifications) {
        this.planDetailModifications = planDetailModifications;
    }
}