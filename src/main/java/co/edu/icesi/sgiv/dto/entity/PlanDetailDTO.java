package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.dto.status.PlanDetailStatusDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class PlanDetailDTO {
    @Getter
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

    public Long getId() {
        return id;
    }
}
