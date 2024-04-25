package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.dto.status.DestinationStatusDTO;
import co.edu.icesi.sgiv.dto.type.DestinationTypeDTO;

import java.sql.Date;

public class DestinationDTO {

    private String code;

    private String name;

    private Date creationDate;

    private DestinationStatusDTO status;

    private DestinationTypeDTO type;


    public DestinationDTO(String code, String name, Date creationDate, DestinationStatusDTO status, DestinationTypeDTO type) {
        this.code = code;
        this.name = name;
        this.creationDate = creationDate;
        this.status = status;
        this.type = type;
    }
}
