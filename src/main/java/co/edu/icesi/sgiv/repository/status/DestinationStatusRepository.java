package co.edu.icesi.sgiv.repository.status;

import co.edu.icesi.sgiv.domain.status.DestinationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DestinationStatusRepository extends JpaRepository<DestinationStatus, Long> {

    public Optional<DestinationStatus> findByName(String name);
}
