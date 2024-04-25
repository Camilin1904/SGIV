package co.edu.icesi.sgiv.mapper.entity;

import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.dto.entity.UserDTO;
import co.edu.icesi.sgiv.mapper.status.UserStatusMapper;
import co.edu.icesi.sgiv.mapper.type.UserTypeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UserStatusMapper.class, UserTypeMapper.class, ClientMapper.class, PlanDetailMapper.class, DestinationMapper.class, PlanMapper.class})
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    public User toEntity(UserDTO userCreationDTO);
    public UserDTO toDTO(User user);

}
