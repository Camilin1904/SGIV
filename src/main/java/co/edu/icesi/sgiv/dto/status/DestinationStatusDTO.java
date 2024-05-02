package co.edu.icesi.sgiv.dto.status;

import co.edu.icesi.sgiv.dto.entity.DestinationDTO;

import java.util.List;

public class DestinationStatusDTO {

    private String name;

    private List<DestinationDTO> destinations;

    public String getName() {
        return name;
    }

    public List<DestinationDTO> getDestinations() {
        return destinations;
    }
}
