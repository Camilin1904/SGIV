package co.edu.icesi.sgiv.repository.modification;

import co.edu.icesi.sgiv.domain.modification.PlanModification;
import co.edu.icesi.sgiv.dto.modification.PlanModificationDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlanModificationRepository extends JpaRepository<PlanModification, Long> {

    public List<PlanModification> findAll();

    @Query("select pm from PlanModification pm join User u on pm.user = u where u.id = (?1)")
    public List<PlanModificationDTO> findByUser(Long uID);

}
