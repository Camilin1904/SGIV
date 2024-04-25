package co.edu.icesi.sgiv.mapper.modification;

import co.edu.icesi.sgiv.domain.modification.PlanModification;
import co.edu.icesi.sgiv.dto.modification.PlanModificationDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PlanModificationMapper {
    public PlanModificationDTO toDTO(PlanModification planModification);
    public List<PlanModificationDTO> toDTOs(List<PlanModification> planModifications);
}
