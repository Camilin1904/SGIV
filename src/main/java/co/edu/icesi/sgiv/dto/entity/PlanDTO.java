package co.edu.icesi.sgiv.dto.entity;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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

    private ClientDTO client;

    private UserDTO user;

    private String status;



}
