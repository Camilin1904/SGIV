package co.edu.icesi.sgiv.domain.entity;

import co.edu.icesi.sgiv.domain.modification.PlanDetailModification;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="plan_detail")
public class        PlanDetail {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "meals_id", nullable = false)
    private Meals meals;

    @OneToMany(mappedBy = "planDetail", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @Column(name = "accommodation", nullable = false, length = 100)
    private List<Accommodation> accommodation;

    @ManyToOne
    @JoinColumn(name = "transportation_id", nullable = false)
    private Transportation transportation;

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

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany(mappedBy = "planDetail", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PlanDetailModification> modifications;

    @ManyToOne
    @JoinColumn(name = "destination", nullable = false)
    private Destination destination;

    @OneToMany(mappedBy = "planDetail", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PlanToPlanDetail> plans;

}
