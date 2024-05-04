package co.edu.icesi.sgiv.dto.status;

import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class DestinationStatusDTO {

    private String name;

    private List<DestinationDTO> destinations;

}
