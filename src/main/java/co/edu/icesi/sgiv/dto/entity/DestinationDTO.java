package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.dto.status.DestinationStatusDTO;
import co.edu.icesi.sgiv.dto.type.DestinationTypeDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class DestinationDTO {
    @Getter
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
}
