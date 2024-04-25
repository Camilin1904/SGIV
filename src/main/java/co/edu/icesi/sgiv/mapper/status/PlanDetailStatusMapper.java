package co.edu.icesi.sgiv.mapper.status;

import co.edu.icesi.sgiv.domain.status.PlanDetailStatus;
import co.edu.icesi.sgiv.dto.status.PlanDetailStatusDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PlanDetailStatusMapper {
    public PlanDetailStatusDTO toDTO(PlanDetailStatus planDetailStatus);


}
