package co.edu.icesi.sgiv.dto.status;

import co.edu.icesi.sgiv.domain.entity.PlanDetail;
import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class PlanDetailStatusDTO {

    private String name;

    private List<PlanDetailDTO> planDetails;
}
