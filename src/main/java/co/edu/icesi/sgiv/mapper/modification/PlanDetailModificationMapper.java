package co.edu.icesi.sgiv.mapper.modification;

import co.edu.icesi.sgiv.domain.modification.PlanDetailModification;
import co.edu.icesi.sgiv.dto.modification.PlanDetailModificationDTO;
import co.edu.icesi.sgiv.mapper.entity.PlanDetailMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = PlanDetailMapper.class)
public interface PlanDetailModificationMapper {

    PlanDetailModificationMapper INSTANCE = Mappers.getMapper(PlanDetailModificationMapper.class);
    @Mapping(target = "id", source = "id")
    public PlanDetailModificationDTO toDTO(PlanDetailModification planDetailModification);
    @Mapping(target = "id", source = "id")
    public List<PlanDetailModificationDTO> toDTOs(List<PlanDetailModification> planDetailModifications);

}
