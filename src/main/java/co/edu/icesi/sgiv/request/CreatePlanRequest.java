package co.edu.icesi.sgiv.request;

import co.edu.icesi.sgiv.dto.entity.ClientDTO;
import co.edu.icesi.sgiv.dto.entity.PlanToPlanDetailDTO;
import co.edu.icesi.sgiv.dto.entity.UserDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlanRequest {
    private String code;
    private Integer numberOfPeople;
    private ClientDTO client;
    private UserDTO user;
    private String status;
    private List<PlanToPlanDetailDTO> planDetails;
}
