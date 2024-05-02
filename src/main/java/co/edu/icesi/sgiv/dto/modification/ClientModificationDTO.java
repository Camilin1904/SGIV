package co.edu.icesi.sgiv.dto.modification;

import co.edu.icesi.sgiv.dto.entity.ClientDTO;
import co.edu.icesi.sgiv.dto.entity.UserDTO;

import java.sql.Date;

public class ClientModificationDTO {

    private Date date;

    private UserDTO user;

    private ClientDTO client;

    public Date getDate() {
        return date;
    }

    public UserDTO getUser() {
        return user;
    }

    public ClientDTO getClient() {
        return client;
    }
}
