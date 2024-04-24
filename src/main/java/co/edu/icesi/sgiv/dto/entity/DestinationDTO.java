package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.domain.entity.PlanDetailDestination;
import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.domain.modification.DestinationModification;
import co.edu.icesi.sgiv.domain.status.DestinationStatus;
import co.edu.icesi.sgiv.domain.type.DestinationType;
import co.edu.icesi.sgiv.dto.status.DestinationStatusDTO;
import co.edu.icesi.sgiv.dto.type.DestinationTypeDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

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
