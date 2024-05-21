package co.edu.icesi.sgiv.mapper.entity;


import co.edu.icesi.sgiv.domain.entity.PlanToPlanDetail;

import co.edu.icesi.sgiv.dto.entity.PlanToPlanDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses={PlanMapper.class, PlanDetailMapper.class})
public interface PlanToPlanDetailMapper {

    PlanToPlanDetailMapper INSTANCE = Mappers.getMapper(PlanToPlanDetailMapper.class);

    @Mapping(target = "id", source = "id")
    public PlanToPlanDetailDTO toDTO(PlanToPlanDetail planToPlanDetail);

    @Mapping(target = "id", source = "id")
    public PlanToPlanDetail toEntity(PlanToPlanDetailDTO plantToPlanDetailDTO);
}
