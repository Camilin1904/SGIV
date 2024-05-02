package co.edu.icesi.sgiv.dto.status;

import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;

import java.util.List;

public class PlanDetailStatusDTO {

    private String name;

    private List<PlanDetailDTO> planDetails;

    public String getName() {
        return name;
    }

    public List<PlanDetailDTO> getPlanDetails() {
        return planDetails;
    }
}
