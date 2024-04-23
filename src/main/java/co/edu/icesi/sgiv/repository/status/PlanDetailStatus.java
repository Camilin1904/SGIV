package co.edu.icesi.sgiv.repository.status;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanDetailStatus extends JpaRepository<PlanDetailStatus, Long> {

    public Optional<PlanDetailStatus> findByName(String name);
}
