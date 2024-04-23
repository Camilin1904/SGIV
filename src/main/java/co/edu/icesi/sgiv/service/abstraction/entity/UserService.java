package co.edu.icesi.sgiv.service.abstraction.entity;

import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.domain.status.UserStatus;
import co.edu.icesi.sgiv.domain.type.UserType;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserService extends GenericService<User, Long> {
    public List<User> findAll();

    public List<User> findAllByType(Long type);

    public Optional<UserStatus> getStatus(Long uID);

    public List<User> getByUserType(UserType ut);
}
