package co.edu.icesi.sgiv.dto.modification;

import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;
import co.edu.icesi.sgiv.dto.entity.UserDTO;

import java.sql.Date;

public class PlanDetailModificationDTO {

    private Date date;

    private UserDTO user;

    private PlanDetailDTO planDetail;

    public Date getDate() {
        return date;
    }

    public UserDTO getUser() {
        return user;
    }

    public PlanDetailDTO getPlanDetail() {
        return planDetail;
    }
}
