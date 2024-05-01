package co.edu.icesi.sgiv.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="plan_detail_destination")
public class PlanDetailDestination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day", nullable = false)
    private int day;

    @ManyToOne
    @JoinColumn(name = "plan_detail_id", nullable = false)
    private PlanDetail planDetail;

    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false)
    private Destination destination;
}
