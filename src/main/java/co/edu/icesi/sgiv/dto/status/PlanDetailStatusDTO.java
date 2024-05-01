package co.edu.icesi.sgiv.dto.status;

import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PlanDetailStatusDTO {

    private String name;

    private List<PlanDetailDTO> planDetails;
}
