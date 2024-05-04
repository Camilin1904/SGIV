package co.edu.icesi.sgiv.dto.modification;

import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import co.edu.icesi.sgiv.dto.entity.UserDTO;
import lombok.Getter;

import java.sql.Date;

@Getter
public class DestinationModificationDTO {


    private Date date;

    private UserDTO user;

    private DestinationDTO destination;

}
