package co.edu.icesi.sgiv.domain.modification;

import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.domain.entity.Meals;
import co.edu.icesi.sgiv.domain.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "meals_modification")
public class MealsModification {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "date", nullable = false, updatable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "modifier_user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "modified_meals_id", nullable = false)
    private Meals meals;

}