package co.edu.icesi.sgiv.mapper.entity;

import co.edu.icesi.sgiv.domain.entity.PlanDetail;
import co.edu.icesi.sgiv.dto.entity.PlanDetailCreationDTO;
import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PlanDetailMapper {

    public PlanDetailDTO toDTO(PlanDetail planDetail);
    public PlanDetail toEntity(PlanDetailCreationDTO planDetailCreationDTO);
    public List<PlanDetailDTO> toDTOs(List<PlanDetail> planDetails);
    public List<PlanDetail> toEntitys(List<PlanDetailCreationDTO> planDetailCreationDTOS);

}
