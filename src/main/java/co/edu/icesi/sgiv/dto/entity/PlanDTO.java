package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.domain.entity.PlanDetail;
import co.edu.icesi.sgiv.domain.status.PlanDetailStatus;
import co.edu.icesi.sgiv.domain.status.PlanStatus;
import co.edu.icesi.sgiv.dto.status.PlanDetailStatusDTO;
import jakarta.persistence.Column;
import lombok.Getter;

import java.sql.Date;

@Getter
public class PlanDTO {

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

    private PlanDetailStatusDTO status;



    public PlanDTO(String code, String requestDescription, String name, Integer numberOfPeople, Date requestDate, Date startDate, Date endDate, Double totalValue, Date creationDate, PlanDetailStatusDTO status, PlanDetailDTO planDetail, ClientDTO client) {
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
        this.client = client;
        this.planDetail = planDetail;
    }
}
