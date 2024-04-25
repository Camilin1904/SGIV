package co.edu.icesi.sgiv.mapper.status;

import co.edu.icesi.sgiv.domain.status.DestinationStatus;
import co.edu.icesi.sgiv.dto.status.DestinationStatusDTO;
import co.edu.icesi.sgiv.mapper.entity.DestinationMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = DestinationMapper.class)
public interface DestinationStatusMapper {

    DestinationMapper INSTANCE = Mappers.getMapper(DestinationMapper.class);

    public DestinationStatusDTO toDTO(DestinationStatus destinationStatus);
}
