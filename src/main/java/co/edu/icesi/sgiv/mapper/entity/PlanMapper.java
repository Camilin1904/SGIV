package co.edu.icesi.sgiv.mapper.entity;

import co.edu.icesi.sgiv.domain.entity.Plan;
import co.edu.icesi.sgiv.dto.entity.PlanCreationDTO;
import co.edu.icesi.sgiv.dto.entity.PlanDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PlanMapper {
    public Plan toEntity(PlanCreationDTO planCreationDTO);
    public PlanDTO toDTO(Plan plan);
    public List<Plan> toEntities(List<PlanCreationDTO> planCreationDTOs);
    public List<PlanDTO> toDTOs(List<Plan> plans);

}
