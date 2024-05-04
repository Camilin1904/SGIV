package co.edu.icesi.sgiv.dto.status;

import co.edu.icesi.sgiv.dto.entity.PlanDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class PlanStatusDTO {

    private String name;

    private List<PlanDTO> plans;

}
