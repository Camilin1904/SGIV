package co.edu.icesi.sgiv.dto.modification;

import co.edu.icesi.sgiv.domain.entity.PlanDetail;
import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;
import co.edu.icesi.sgiv.dto.entity.UserDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
public class PlanDetailModificationDTO {

    private Date date;

    private UserDTO user;

    private PlanDetailDTO planDetail;
}
