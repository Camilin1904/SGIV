package co.edu.icesi.sgiv.mapper.status;

import co.edu.icesi.sgiv.domain.status.DestinationStatus;
import co.edu.icesi.sgiv.dto.status.DestinationStatusDTO;
import co.edu.icesi.sgiv.mapper.entity.DestinationMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = DestinationMapper.class)
public interface DestinationStatusMapper {

    DestinationStatusMapper INSTANCE = Mappers.getMapper(DestinationStatusMapper.class);

    @Mapping(target = "id", source = "id")
    public DestinationStatusDTO toDTO(DestinationStatus destinationStatus);
    @Mapping(target = "id", source = "id")
    public DestinationStatus toEntity(DestinationStatusDTO destinationStatusDTO);
}
