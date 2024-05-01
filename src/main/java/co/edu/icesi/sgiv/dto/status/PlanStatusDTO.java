package co.edu.icesi.sgiv.dto.status;

import co.edu.icesi.sgiv.dto.entity.PlanDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PlanStatusDTO {

    private String name;

    private List<PlanDTO> plans;
}
