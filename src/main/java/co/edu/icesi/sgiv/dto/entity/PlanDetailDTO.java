package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.dto.status.PlanDetailStatusDTO;

import java.sql.Date;

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

    public Long getId() {
        return id;
    }

    public String getFood() {
        return food;
    }

    public String getAccommodation() {
        return accommodation;
    }

    public String getTransportation() {
        return transportation;
    }

    public String getTransfers() {
        return transfers;
    }

    public Double getValue() {
        return value;
    }

    public Integer getNumberOfNights() {
        return numberOfNights;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public UserDTO getUser() {
        return user;
    }

    public PlanDetailStatusDTO getStatus() {
        return status;
    }
}
