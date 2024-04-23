package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.domain.status.PlanDetailStatus;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.sql.Date;

public class PlanDetailDTO {

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
