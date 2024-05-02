package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.dto.status.DestinationStatusDTO;
import co.edu.icesi.sgiv.dto.type.DestinationTypeDTO;

import java.sql.Date;

public class DestinationDTO {
    private Long id;
    private String code;

    private String name;

    private Date creationDate;

    private UserDTO user;
    private DestinationStatusDTO status;

    private DestinationTypeDTO type;


    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public UserDTO getUser() {
        return user;
    }

    public DestinationStatusDTO getStatus() {
        return status;
    }

    public DestinationTypeDTO getType() {
        return type;
    }
}
