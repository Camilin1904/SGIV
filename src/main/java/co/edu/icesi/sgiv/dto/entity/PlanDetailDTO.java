package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.dto.status.PlanDetailStatusDTO;
import lombok.Getter;

import java.sql.Date;

@Getter
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

    public PlanDetailDTO(String food, String accommodation, String transportation, String transfers, Double value, Integer numberOfNights, Integer numberOfDays, Date creationDate, UserDTO user, PlanDetailStatusDTO status) {
        this.food = food;
        this.accommodation = accommodation;
        this.transportation = transportation;
        this.transfers = transfers;
        this.value = value;
        this.numberOfNights = numberOfNights;
        this.numberOfDays = numberOfDays;
        this.creationDate = creationDate;
        this.user = user;
        this.status = status;
    }
}
