package co.edu.icesi.sgiv.dto.modification;

import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import co.edu.icesi.sgiv.dto.entity.UserDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Getter
public class DestinationModificationDTO {


    private Date date;

    private UserDTO user;

    private DestinationDTO destination;
}
