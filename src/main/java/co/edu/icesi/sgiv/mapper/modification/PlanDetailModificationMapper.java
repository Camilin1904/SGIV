package co.edu.icesi.sgiv.mapper.modification;

import co.edu.icesi.sgiv.domain.modification.PlanDetailModification;
import co.edu.icesi.sgiv.dto.modification.PlanDetailModificationDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PlanDetailModificationMapper {
    public PlanDetailModificationDTO toDTO(PlanDetailModification planDetailModification);
    public List<PlanDetailModificationDTO> toDTOs(List<PlanDetailModification> planDetailModifications);

}
