package co.edu.icesi.sgiv.domain.entity;

import co.edu.icesi.sgiv.domain.modification.PlanDetailModification;
import co.edu.icesi.sgiv.domain.status.PlanDetailStatus;
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
public class    PlanDetail {
    @Getter
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

}
