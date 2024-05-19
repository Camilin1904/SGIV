package co.edu.icesi.sgiv.domain.entity;

import co.edu.icesi.sgiv.domain.modification.PlanModification;
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
@Table(name = "plan")
public class Plan {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "code", nullable = false, length = 50)
    private String code;

    @Column(name = "number_of_people", nullable = false)
    private Integer numberOfPeople;


    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "total_value", nullable = false)
    private Double totalValue;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "creator_user_id", nullable = false)
    private User user;

    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "plan_detail_id", nullable = false)
    private PlanDetail planDetail;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PlanModification> modifications;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PlanToPlanDetail> planDetails;


}
