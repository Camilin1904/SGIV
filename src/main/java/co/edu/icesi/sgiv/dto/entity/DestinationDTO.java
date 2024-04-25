package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.dto.status.DestinationStatusDTO;
import co.edu.icesi.sgiv.dto.type.DestinationTypeDTO;
import lombok.Getter;

import java.sql.Date;

@Getter
public class DestinationDTO {

    private Long id;
    private String code;

    private String name;

    private Date creationDate;

    private UserDTO user;
    private DestinationStatusDTO status;

    private DestinationTypeDTO type;


    public DestinationDTO(String code, String name, Date creationDate, UserDTO user, DestinationStatusDTO status, DestinationTypeDTO type) {
        this.code = code;
        this.name = name;
        this.creationDate = creationDate;
        this.user = user;
        this.status = status;
        this.type = type;
    }
}
