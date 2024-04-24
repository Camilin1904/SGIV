package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.dto.status.DestinationStatusDTO;
import co.edu.icesi.sgiv.dto.type.DestinationTypeDTO;
import lombok.Getter;

import java.sql.Date;

@Getter
public class DestinationCreationDTO {
    private String code;

    private String name;

    private Date creationDate;

    private UserDTO creator;

    private DestinationStatusDTO status;

    private DestinationTypeDTO type;


    public DestinationCreationDTO(String code, String name, Date creationDate, UserDTO creator, DestinationStatusDTO status, DestinationTypeDTO type) {
        this.code = code;
        this.name = name;
        this.creationDate = creationDate;
        this.creator = creator;
        this.status = status;
        this.type = type;
    }
}
