package co.edu.icesi.sgiv.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="meals_configuration")
public class MealsConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    @OneToMany(mappedBy = "mealsConfigutration", cascade = CascadeType.ALL)
    private List<PlanDetail> planDetails;

    @Column(name = "status", nullable = false)
    private String status;


}
