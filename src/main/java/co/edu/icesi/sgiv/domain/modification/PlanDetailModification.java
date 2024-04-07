package co.edu.icesi.sgiv.domain.modification;

import co.edu.icesi.sgiv.domain.entitie.Client;
import co.edu.icesi.sgiv.domain.entitie.PlanDetail;
import co.edu.icesi.sgiv.domain.entitie.User;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "plan_detail_modification")
public class PlanDetailModification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "date", nullable = false, updatable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "modifier_user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "modified_plan_detail_id", nullable = false)
    private PlanDetail planDetail;
}
