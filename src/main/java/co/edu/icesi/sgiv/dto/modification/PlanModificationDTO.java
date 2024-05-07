package co.edu.icesi.sgiv.dto.modification;

import co.edu.icesi.sgiv.dto.entity.PlanDTO;
import co.edu.icesi.sgiv.dto.entity.UserDTO;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PlanModificationDTO {

    private Long id;

    private Date date;

    private UserDTO user;

    private PlanDTO plan;
}
