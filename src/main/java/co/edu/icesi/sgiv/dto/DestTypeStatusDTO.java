package co.edu.icesi.sgiv.dto;

import co.edu.icesi.sgiv.dto.status.DestinationStatusDTO;
import co.edu.icesi.sgiv.dto.type.DestinationTypeDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DestTypeStatusDTO {
    private List<DestinationTypeDTO> destinationType;
    private List<DestinationStatusDTO> destinationStatus;

}
