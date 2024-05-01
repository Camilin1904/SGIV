package co.edu.icesi.sgiv.dto.status;

import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DestinationStatusDTO {

    private String name;

    private List<DestinationDTO> destinations;
}
