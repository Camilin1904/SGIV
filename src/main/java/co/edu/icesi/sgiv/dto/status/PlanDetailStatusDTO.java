package co.edu.icesi.sgiv.dto.status;

import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PlanDetailStatusDTO {

    private Long id;

    private String name;

    private List<PlanDetailDTO> planDetails;

}
