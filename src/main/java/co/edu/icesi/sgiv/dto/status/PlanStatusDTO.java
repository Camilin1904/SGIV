package co.edu.icesi.sgiv.dto.status;

import co.edu.icesi.sgiv.domain.entity.Plan;
import co.edu.icesi.sgiv.dto.entity.PlanDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class PlanStatusDTO {

    private String name;

    private List<PlanDTO> plans;
}
