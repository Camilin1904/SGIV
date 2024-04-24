package co.edu.icesi.sgiv.dto.status;

import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class DestinationStatusDTO {

    private String name;

    private List<DestinationDTO> destinations;
}
