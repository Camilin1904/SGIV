package co.edu.icesi.sgiv.mapper.entity;

import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.dto.entity.UserDTO;
import co.edu.icesi.sgiv.mapper.type.UserTypeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UserTypeMapper.class, ClientMapper.class, PlanDetailMapper.class, DestinationMapper.class, PlanMapper.class, UserTypeMapper.class})
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    @Mapping(target = "id", source = "id")
    public User toEntity(UserDTO userCreationDTO);
    @Mapping(target = "id", source = "id")
    public UserDTO toDTO(User user);

}
