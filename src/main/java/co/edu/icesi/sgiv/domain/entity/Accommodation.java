package co.edu.icesi.sgiv.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "accomodation")
public class Accommodation {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(name = "amount_of_people", nullable = false)
    private Integer amountOfPeople;

    @ManyToOne
    @JoinColumn(name = "plan_detail_id", nullable = false)
    private PlanDetail planDetail;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;


    @Column(name = "status", nullable = false)
    private String status;
}