package co.edu.icesi.sgiv.dto.modification;

import co.edu.icesi.sgiv.dto.entity.PlanDTO;
import co.edu.icesi.sgiv.dto.entity.UserDTO;

import java.sql.Date;

public class PlanModificationDTO {

    private Date date;

    private UserDTO user;

    private PlanDTO plan;

    public Date getDate() {
        return date;
    }

    public UserDTO getUser() {
        return user;
    }

    public PlanDTO getPlan() {
        return plan;
    }
}
