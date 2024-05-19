package co.edu.icesi.sgiv.mapper.status;

import co.edu.icesi.sgiv.dto.status.PlanStatusDTO;
import co.edu.icesi.sgiv.mapper.entity.PlanMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = PlanMapper.class)
public interface PlanStatusMapper {

    PlanStatusMapper INSTANCE = Mappers.getMapper(PlanStatusMapper.class);

    @Mapping(target = "id", source = "id")
    public PlanStatusDTO toDTO(PlanStatus planStatus);
    @Mapping(target = "id", source = "id")
    public PlanStatus toEntity(PlanStatusDTO planStatusDTO);
}
