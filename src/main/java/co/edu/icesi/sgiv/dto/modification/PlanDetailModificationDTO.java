package co.edu.icesi.sgiv.dto.modification;

import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;
import co.edu.icesi.sgiv.dto.entity.UserDTO;
import lombok.Getter;

import java.sql.Date;

@Getter
public class PlanDetailModificationDTO {

    private Date date;

    private UserDTO user;

    private PlanDetailDTO planDetail;
}
