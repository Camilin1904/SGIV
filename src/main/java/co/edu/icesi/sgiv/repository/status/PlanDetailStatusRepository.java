package co.edu.icesi.sgiv.repository.status;

import co.edu.icesi.sgiv.domain.status.PlanDetailStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanDetailStatusRepository extends JpaRepository<PlanDetailStatus, Long> {

    public Optional<PlanDetailStatus> findByName(String name);
}
