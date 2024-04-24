package co.edu.icesi.sgiv.mapper.status;

import co.edu.icesi.sgiv.domain.status.PlanStatus;
import co.edu.icesi.sgiv.dto.status.PlanStatusDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PlanStatusMapper {
    public PlanStatusDTO toDTO(PlanStatus planStatus);
}
