package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.dto.resources.DestinationImageDTO;
import co.edu.icesi.sgiv.dto.type.DestinationTypeDTO;
import lombok.*;

import java.sql.Date;
import java.util.List;

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
    private String status;

    private DestinationTypeDTO type;

    private List<DestinationImageDTO> images;

}
