package co.edu.icesi.sgiv.mapper.type;

import co.edu.icesi.sgiv.domain.type.DestinationType;
import co.edu.icesi.sgiv.dto.type.DestinationTypeDTO;
import org.mapstruct.Mapper;

@Mapper
public interface DestinationTypeMapper {
    public DestinationTypeDTO toDTO(DestinationType destinationType);

}
