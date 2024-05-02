package co.edu.icesi.sgiv.dto.status;

import co.edu.icesi.sgiv.dto.entity.PlanDTO;

import java.util.List;

public class PlanStatusDTO {

    private String name;

    private List<PlanDTO> plans;

    public String getName() {
        return name;
    }

    public List<PlanDTO> getPlans() {
        return plans;
    }
}
