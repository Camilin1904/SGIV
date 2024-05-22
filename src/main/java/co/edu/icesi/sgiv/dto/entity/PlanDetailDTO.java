package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.domain.entity.Meals;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PlanDetailDTO {
    private Long id;

    private String name;

    private TransportationDTO transportation;

    private MealsDTO meals;

    private Double value;

    private DestinationDTO destination;

    private Integer numberOfNights;

    private Integer numberOfDays;

    private Date creationDate;

    private UserDTO user;

    private String status;

}
