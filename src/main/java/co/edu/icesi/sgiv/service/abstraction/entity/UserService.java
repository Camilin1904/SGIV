package co.edu.icesi.sgiv.service.abstraction.entity;

import co.edu.icesi.sgiv.domain.status.UserStatus;
import co.edu.icesi.sgiv.domain.type.UserType;
import co.edu.icesi.sgiv.dto.entity.UserDTO;
import co.edu.icesi.sgiv.dto.status.UserStatusDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface UserService extends GenericService<UserDTO, Long> {
    public List<UserDTO> findAll();

    public List<UserDTO> findAllByType(Long type);

    public Optional<UserStatusDTO> getStatus(Long uID);
}
