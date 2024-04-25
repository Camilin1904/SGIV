package co.edu.icesi.sgiv.repository.type;

import co.edu.icesi.sgiv.domain.type.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTypeRepository extends JpaRepository<UserType, Long> {

    public List<UserType> findAll();
}
