package co.edu.icesi.sgiv.mapper.type;

import co.edu.icesi.sgiv.domain.type.UserType;
import co.edu.icesi.sgiv.dto.type.UserTypeDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserTypeMapper {
    public UserTypeDTO toDTO(UserType userType);
}
