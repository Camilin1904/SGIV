package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.dto.status.UserStatusDTO;
import co.edu.icesi.sgiv.dto.type.UserTypeDTO;

import java.sql.Date;

public class UserCreationDTO {

    private String username;

    private String password;

    private Date creationDate;

    private String email;

    private UserStatusDTO status;

    private UserTypeDTO type;

    public UserCreationDTO(String username, String password, Date creationDate, String email, UserStatusDTO status, UserTypeDTO type) {
        this.username = username;
        this.password = password;
        this.creationDate = creationDate;
        this.email = email;
        this.status = status;
        this.type = type;
    }
}
