package co.edu.icesi.sgiv.dto.entity;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PlanToPlanDetailDTO {

    private Long id;

    private Date startDate;

    private Date endDate;

    private PlanDetailDTO planDetail;

    private PlanDTO plan;

    private String status;
}
