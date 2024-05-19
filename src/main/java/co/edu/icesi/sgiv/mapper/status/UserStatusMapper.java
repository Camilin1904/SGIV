package co.edu.icesi.sgiv.mapper.status;

import co.edu.icesi.sgiv.dto.status.UserStatusDTO;
import co.edu.icesi.sgiv.mapper.entity.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = UserMapper.class)
public interface UserStatusMapper {

    UserStatusMapper INSTANCE = Mappers.getMapper(UserStatusMapper.class);

    @Mapping(target = "id", source = "id")
    public abstract UserStatusDTO toDTO(UserStatus userStatus);
    @Mapping(target = "id", source = "id")
    public abstract UserStatus toEntity(UserStatusDTO userStatusDTO);


}
