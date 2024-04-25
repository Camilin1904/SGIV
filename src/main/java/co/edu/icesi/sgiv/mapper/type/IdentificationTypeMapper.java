package co.edu.icesi.sgiv.mapper.type;

import co.edu.icesi.sgiv.domain.type.IdentificationType;
import co.edu.icesi.sgiv.dto.type.IdentificationTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IdentificationTypeMapper {

    IdentificationTypeMapper INSTANCE = Mappers.getMapper(IdentificationTypeMapper.class);

    public IdentificationTypeDTO toDTO(IdentificationType entity);
}
