package co.edu.icesi.sgiv.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="plan_detail_destination")
public class PlanDetailDestination {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "days", nullable = false)
    private String days;

    @ManyToOne
    @JoinColumn(name = "plan_detail_id", nullable = false)
    private PlanDetail planDetail;

    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false)
    private Destination destination;

}
