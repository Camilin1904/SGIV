package co.edu.icesi.sgiv.repository.status;

import co.edu.icesi.sgiv.domain.status.PlanStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanStatusRepository extends JpaRepository<PlanStatus, Long> {

    public Optional<PlanStatus> findByName(String name);
}
