package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.dto.status.PlanDetailStatusDTO;
import co.edu.icesi.sgiv.dto.status.PlanStatusDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class PlanDTO {
    @Getter
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

}
