package co.edu.icesi.sgiv.repository.status;

import co.edu.icesi.sgiv.domain.status.ClientStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientStatusRepository extends JpaRepository<ClientStatus, Long> {
    public Optional<ClientStatus> findByName(String name);
}
