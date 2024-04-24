package co.edu.icesi.sgiv.mapper.type;

import co.edu.icesi.sgiv.domain.type.IdentificationType;
import co.edu.icesi.sgiv.dto.type.IdentificationTypeDTO;
import org.mapstruct.Mapper;

@Mapper
public interface IdentificationTypeMapper {
    public IdentificationTypeDTO toDTO(IdentificationType entity);
}
