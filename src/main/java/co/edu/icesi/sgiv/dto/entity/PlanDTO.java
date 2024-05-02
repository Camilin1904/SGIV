package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.dto.status.PlanStatusDTO;

import java.sql.Date;

public class PlanDTO {
    private Long id;

    private String code;

    private String requestDescription;

    private String name;

    private Integer numberOfPeople;

    private Date requestDate;

    private Date startDate;

    private Date endDate;

    private Double totalValue;

    private Date creationDate;

    private PlanDetailDTO planDetail;

    private ClientDTO client;

    private UserDTO user;

    private PlanStatusDTO status;

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public String getName() {
        return name;
    }

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public PlanDetailDTO getPlanDetail() {
        return planDetail;
    }

    public ClientDTO getClient() {
        return client;
    }

    public UserDTO getUser() {
        return user;
    }

    public PlanStatusDTO getStatus() {
        return status;
    }
}
