package co.edu.icesi.sgiv.mapper.entity;

import co.edu.icesi.sgiv.domain.entity.Plan;
import co.edu.icesi.sgiv.dto.entity.PlanDTO;
import co.edu.icesi.sgiv.mapper.status.PlanStatusMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ClientMapper.class, PlanDetailMapper.class, PlanStatusMapper.class, UserMapper.class})
public interface PlanMapper {

    PlanMapper INSTANCE = Mappers.getMapper(PlanMapper.class);
    @Mapping(target = "id", source = "id")
    public Plan toEntity(PlanDTO planCreationDTO);
    @Mapping(target = "id", source = "id")
    public PlanDTO toDTO(Plan plan);

}
