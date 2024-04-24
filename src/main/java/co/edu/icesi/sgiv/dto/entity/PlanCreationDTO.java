package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.dto.status.PlanStatusDTO;
import lombok.Getter;

import java.sql.Date;

@Getter
public class PlanCreationDTO {

    private String code;

    private String requestDescription;

    private String name;

    private Integer numberOfPeople;

    private Date requestDate;

    private Date startDate;

    private Date endDate;

    private Double totalValue;

    private Date creationDate;

    private PlanStatusDTO status;

    private UserDTO creator;

    private PlanDetailDTO planDetail;


    public PlanCreationDTO(String code, String requestDescription, String name, Integer numberOfPeople, Date requestDate, Date startDate, Date endDate, Double totalValue, Date creationDate, PlanStatusDTO status, UserDTO creator, PlanDetailDTO planDetail) {
        this.code = code;
        this.requestDescription = requestDescription;
        this.name = name;
        this.numberOfPeople = numberOfPeople;
        this.requestDate = requestDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalValue = totalValue;
        this.creationDate = creationDate;
        this.status = status;
        this.creator = creator;
        this.planDetail = planDetail;
    }
}
