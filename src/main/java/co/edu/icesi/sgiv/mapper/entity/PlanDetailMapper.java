package co.edu.icesi.sgiv.mapper.entity;

import co.edu.icesi.sgiv.domain.entity.PlanDetail;
import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;
import co.edu.icesi.sgiv.mapper.status.PlanDetailStatusMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {PlanDetailStatusMapper.class, UserMapper.class})
public interface PlanDetailMapper {

    PlanDetailMapper INSTANCE = Mappers.getMapper(PlanDetailMapper.class);

    public PlanDetailDTO toDTO(PlanDetail planDetail);

    public PlanDetail toEntity(PlanDetailDTO planDetailDTO);

}
