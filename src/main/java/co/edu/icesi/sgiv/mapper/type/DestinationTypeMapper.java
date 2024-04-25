package co.edu.icesi.sgiv.mapper.type;

import co.edu.icesi.sgiv.domain.type.DestinationType;
import co.edu.icesi.sgiv.dto.type.DestinationTypeDTO;
import co.edu.icesi.sgiv.mapper.entity.DestinationMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DestinationTypeMapper {

    DestinationTypeMapper INSTANCE = Mappers.getMapper(DestinationTypeMapper.class);

    public DestinationTypeDTO toDTO(DestinationType destinationType);

}
