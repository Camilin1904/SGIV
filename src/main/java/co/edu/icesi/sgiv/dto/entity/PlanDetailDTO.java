package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.dto.status.PlanDetailStatusDTO;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PlanDetailDTO {
    private Long id;
    private String food;

    private String accommodation;

    private String transportation;

    private String transfers;

    private Double value;

    private Integer numberOfNights;

    private Integer numberOfDays;

    private Date creationDate;

    private UserDTO user;

    private PlanDetailStatusDTO status;

}
