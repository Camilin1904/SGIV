package co.edu.icesi.sgiv.mapper.entity;

import co.edu.icesi.sgiv.domain.entity.Plan;
import co.edu.icesi.sgiv.dto.entity.PlanDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ClientMapper.class, PlanDetailMapper.class, UserMapper.class})
public interface PlanMapper {

    PlanMapper INSTANCE = Mappers.getMapper(PlanMapper.class);
    @Mapping(target = "id", source = "id")
    public Plan toEntity(PlanDTO planCreationDTO);
    @Mapping(target = "id", source = "id")
    public PlanDTO toDTO(Plan plan);

}
