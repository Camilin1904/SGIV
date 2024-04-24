package co.edu.icesi.sgiv.mapper.status;

import co.edu.icesi.sgiv.domain.status.UserStatus;
import co.edu.icesi.sgiv.dto.status.UserStatusDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserStatusMapper {
    public abstract UserStatusDTO toDTO(UserStatus userStatus);

}
