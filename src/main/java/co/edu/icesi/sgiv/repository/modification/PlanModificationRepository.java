package co.edu.icesi.sgiv.repository.modification;

import co.edu.icesi.sgiv.domain.modification.PlanDetailModification;
import co.edu.icesi.sgiv.domain.modification.PlanModification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlanModificationRepository extends JpaRepository<PlanModification, Long> {

    public List<PlanModification> findAll();

    @Query("select pm from PlanModification pm join User u on pm.user = u where u.id = (?1)")
    public List<PlanModification> findByUser(Long uID);

}
