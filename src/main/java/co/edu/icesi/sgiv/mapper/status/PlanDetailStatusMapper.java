package co.edu.icesi.sgiv.mapper.status;

import co.edu.icesi.sgiv.domain.entity.Plan;
import co.edu.icesi.sgiv.domain.status.PlanDetailStatus;
import co.edu.icesi.sgiv.dto.status.PlanDetailStatusDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PlanDetailStatusMapper {
    public PlanDetailStatusDTO toDTO(PlanDetailStatus planDetailStatus);


}
