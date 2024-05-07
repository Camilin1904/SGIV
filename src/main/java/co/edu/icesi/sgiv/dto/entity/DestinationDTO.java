package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.dto.status.DestinationStatusDTO;
import co.edu.icesi.sgiv.dto.type.DestinationTypeDTO;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DestinationDTO {
    private Long id;
    private String code;

    private String name;

    private Date creationDate;

    private UserDTO user;
    private DestinationStatusDTO status;

    private DestinationTypeDTO type;

}
