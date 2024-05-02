package co.edu.icesi.sgiv.dto.modification;

import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import co.edu.icesi.sgiv.dto.entity.UserDTO;

import java.sql.Date;


public class DestinationModificationDTO {


    private Date date;

    private UserDTO user;

    private DestinationDTO destination;

    public Date getDate() {
        return date;
    }

    public UserDTO getUser() {
        return user;
    }

    public DestinationDTO getDestination() {
        return destination;
    }
}
