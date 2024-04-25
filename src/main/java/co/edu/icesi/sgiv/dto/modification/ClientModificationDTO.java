package co.edu.icesi.sgiv.dto.modification;

import co.edu.icesi.sgiv.dto.entity.ClientDTO;
import co.edu.icesi.sgiv.dto.entity.UserDTO;
import lombok.Getter;

import java.sql.Date;

@Getter
public class ClientModificationDTO {

    private Date date;

    private UserDTO user;

    private ClientDTO client;
}
