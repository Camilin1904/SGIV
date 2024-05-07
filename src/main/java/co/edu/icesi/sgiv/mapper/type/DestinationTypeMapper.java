package co.edu.icesi.sgiv.mapper.type;

import co.edu.icesi.sgiv.domain.type.DestinationType;
import co.edu.icesi.sgiv.dto.type.DestinationTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DestinationTypeMapper {

    DestinationTypeMapper INSTANCE = Mappers.getMapper(DestinationTypeMapper.class);

    @Mapping(target = "id", source = "id")
    public DestinationTypeDTO toDTO(DestinationType destinationType);
    @Mapping(target = "id", source = "id")
    public DestinationType toEntity(DestinationTypeDTO destinationTypeDTO);

}
