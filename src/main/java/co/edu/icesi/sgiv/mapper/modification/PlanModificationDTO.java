package co.edu.icesi.sgiv.mapper.modification;

import co.edu.icesi.sgiv.domain.modification.PlanModification;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PlanModificationDTO {
    public PlanModificationDTO toDTO(PlanModification planModification);
    public List<PlanModificationDTO> toDTOs(List<PlanModification> planModifications);
}
