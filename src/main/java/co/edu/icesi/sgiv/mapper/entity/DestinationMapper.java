package co.edu.icesi.sgiv.mapper.entity;

import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import co.edu.icesi.sgiv.mapper.status.DestinationStatusMapper;
import co.edu.icesi.sgiv.mapper.type.DestinationTypeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DestinationStatusMapper.class, DestinationTypeMapper.class, UserMapper.class})
public interface DestinationMapper {

    DestinationMapper INSTANCE = Mappers.getMapper(DestinationMapper.class);

    public DestinationDTO toDTO(Destination destination);
    public Destination toEntity(DestinationDTO destinationCreationDTO);
}
