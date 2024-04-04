package co.edu.icesi.sgiv.domain;

import jakarta.persistence.*;

import java.sql.Date;
@Entity
@Table(name="plan_details")
public class PlanDetails {

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
}
