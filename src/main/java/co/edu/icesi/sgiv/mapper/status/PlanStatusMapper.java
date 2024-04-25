package co.edu.icesi.sgiv.mapper.status;

import co.edu.icesi.sgiv.domain.status.PlanStatus;
import co.edu.icesi.sgiv.dto.status.PlanStatusDTO;
import co.edu.icesi.sgiv.mapper.entity.PlanMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = PlanMapper.class)
public interface PlanStatusMapper {

    PlanStatusMapper INSTANCE = Mappers.getMapper(PlanStatusMapper.class);

    public PlanStatusDTO toDTO(PlanStatus planStatus);
}
