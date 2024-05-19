package co.edu.icesi.sgiv.mapper.status;

import co.edu.icesi.sgiv.dto.status.PlanDetailStatusDTO;
import co.edu.icesi.sgiv.mapper.entity.PlanDetailMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = PlanDetailMapper.class)
public interface PlanDetailStatusMapper {

    PlanDetailStatusMapper INSTANCE = Mappers.getMapper(PlanDetailStatusMapper.class);

    @Mapping(target = "id", source = "id")
    public PlanDetailStatusDTO toDTO(PlanDetailStatus planDetailStatus);
    @Mapping(target = "id", source = "id")
    public PlanDetailStatus toEntity(PlanDetailStatusDTO planDetailStatusDTO);


}
