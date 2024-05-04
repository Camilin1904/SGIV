package co.edu.icesi.sgiv.mapper.status;

import co.edu.icesi.sgiv.domain.status.UserStatus;
import co.edu.icesi.sgiv.dto.status.UserStatusDTO;
import co.edu.icesi.sgiv.mapper.entity.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = UserMapper.class)
public interface UserStatusMapper {

    UserStatusMapper INSTANCE = Mappers.getMapper(UserStatusMapper.class);

    public abstract UserStatusDTO toDTO(UserStatus userStatus);


}
