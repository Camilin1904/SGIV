package co.edu.icesi.sgiv.dto.entity;

import lombok.Getter;

import java.sql.Date;

@Getter
public class planCreationDTO {

    private String code;

    private String requestDescription;

    private String name;

    private Integer numberOfPeople;

    private Date requestDate;

    private Date startDate;

    private Date endDate;

    private Double totalValue;

    private Date creationDate;

    private planStatusDTO status;

    private UserDTO creator;

    private PlanDetailDTO planDetail;


    public planCreationDTO(String code, String requestDescription, String name, Integer numberOfPeople, Date requestDate, Date startDate, Date endDate, Double totalValue, Date creationDate, String status, String creator, String planDetail) {
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
