package co.edu.icesi.sgiv.dto.type;

import co.edu.icesi.sgiv.domain.entity.Destination;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class DestinationTypeDTO {

    private String name;

    private String description;

}
