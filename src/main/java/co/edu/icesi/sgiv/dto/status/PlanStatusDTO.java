package co.edu.icesi.sgiv.dto.status;

import co.edu.icesi.sgiv.dto.entity.PlanDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PlanStatusDTO {

    private Long id;

    private String name;

    private List<PlanDTO> plans;

}
