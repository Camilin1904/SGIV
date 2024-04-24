package co.edu.icesi.sgiv.mapper.entity;

import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.dto.entity.UserCreationDTO;
import co.edu.icesi.sgiv.dto.entity.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public User toEntity(UserCreationDTO userCreationDTO);
    public UserDTO toDTO(User user);
    public List<User> toEntity(List<UserCreationDTO> userCreationDTOS);
    public List<UserDTO> toDTO(List<User> users);

}
