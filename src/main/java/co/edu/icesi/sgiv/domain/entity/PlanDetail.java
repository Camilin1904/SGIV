package co.edu.icesi.sgiv.domain.entity;

import co.edu.icesi.sgiv.domain.modification.PlanDetailModification;
import co.edu.icesi.sgiv.domain.status.PlanDetailStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name="plan_detail")
public class PlanDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "food", nullable = false, length = 100)
    private String food;

    @Column(name = "accommodation", nullable = false, length = 100)
    private String accommodation;

    @Column(name = "transportation", nullable = false, length = 100)
    private String transportation;

    @Column(name = "transfers", nullable = false, length = 100)
    private String transfers;

    @Column(name = "value", nullable = false)
    private Double value;

    @Column(name = "number_of_nights", nullable = false)
    private Integer numberOfNights;

    @Column(name = "number_of_days", nullable = false)
    private Integer numberOfDays;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "creator_user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private PlanDetailStatus status;

    @OneToMany(mappedBy = "planDetail", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PlanDetailModification> modifications;

    @OneToMany(mappedBy = "planDetail", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Plan> plans;

    @OneToMany(mappedBy = "planDetail", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PlanDetailDestination> planDetailDestinations;

    public PlanDetail() {
    }

    public Long getId() {
        return id;
    }


    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }

    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public String getTransfers() {
        return transfers;
    }

    public void setTransfers(String transfers) {
        this.transfers = transfers;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(Integer numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PlanDetailStatus getStatus() {
        return status;
    }

    public void setStatus(PlanDetailStatus status) {
        this.status = status;
    }

    public List<PlanDetailModification> getModifications() {
        return modifications;
    }

    public void setModifications(List<PlanDetailModification> modifications) {
        this.modifications = modifications;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }

    public List<PlanDetailDestination> getPlanDetailDestinations() {
        return planDetailDestinations;
    }

    public void setPlanDetailDestinations(List<PlanDetailDestination> planDetailDestinations) {
        this.planDetailDestinations = planDetailDestinations;
    }
}
