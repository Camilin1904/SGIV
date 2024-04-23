package co.edu.icesi.sgiv.repository.status;

import co.edu.icesi.sgiv.domain.status.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserStatusRepository extends JpaRepository<UserStatus, Long> {

    public Optional<UserStatus> findByName(String name);
}
