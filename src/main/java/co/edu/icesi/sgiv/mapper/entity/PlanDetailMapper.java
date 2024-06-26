package co.edu.icesi.sgiv.mapper.entity;

import co.edu.icesi.sgiv.domain.entity.PlanDetail;
import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;
import co.edu.icesi.sgiv.mapper.status.PlanDetailStatusMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {PlanDetailStatusMapper.class, UserMapper.class})
public interface PlanDetailMapper {

    PlanDetailMapper INSTANCE = Mappers.getMapper(PlanDetailMapper.class);
    @Mapping(target = "id", source = "id")
    public PlanDetailDTO toDTO(PlanDetail planDetail);
    @Mapping(target = "id", source = "id")
    public PlanDetail toEntity(PlanDetailDTO planDetailDTO);

}
