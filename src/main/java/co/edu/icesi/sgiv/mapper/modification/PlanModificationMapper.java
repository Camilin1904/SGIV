package co.edu.icesi.sgiv.mapper.modification;

import co.edu.icesi.sgiv.domain.modification.PlanModification;
import co.edu.icesi.sgiv.dto.modification.PlanModificationDTO;
import co.edu.icesi.sgiv.mapper.entity.PlanMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = PlanMapper.class)
public interface PlanModificationMapper {

    PlanModificationMapper INSTANCE = Mappers.getMapper(PlanModificationMapper.class);

    public PlanModificationDTO toDTO(PlanModification planModification);
    public List<PlanModificationDTO> toDTOs(List<PlanModification> planModifications);
}
