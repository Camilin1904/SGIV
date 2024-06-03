package co.edu.icesi.sgiv.service.abstraction.entity;

import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.dto.entity.UserDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface UserService extends GenericService<UserDTO, Long> {
    public List<UserDTO> findAll();

    public List<UserDTO> findAllByType(Long type);

    public Optional<User> findByUsername(String username);

    public Page<UserDTO> findByFilter(String name, Long type, String status, Pageable page);

}
