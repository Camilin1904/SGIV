package co.edu.icesi.sgiv.mapper.type;

import co.edu.icesi.sgiv.domain.type.UserType;
import co.edu.icesi.sgiv.dto.type.UserTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserTypeMapper {

    UserTypeMapper INSTANCE = Mappers.getMapper(UserTypeMapper.class);

    @Mapping(target = "id", source = "id")
    public UserTypeDTO toDTO(UserType userType);
    @Mapping(target = "id", source = "id")
    public UserType toEntity(UserTypeDTO userTypeDTO);
}
