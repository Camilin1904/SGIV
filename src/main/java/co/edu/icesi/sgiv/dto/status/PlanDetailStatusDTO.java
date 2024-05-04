package co.edu.icesi.sgiv.dto.status;

import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class PlanDetailStatusDTO {

    private String name;

    private List<PlanDetailDTO> planDetails;

}
