package co.edu.icesi.sgiv.repository.modification;


import co.edu.icesi.sgiv.domain.modification.ClientModification;
import co.edu.icesi.sgiv.domain.modification.PlanDetailModification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlanDetailModificationRepository extends JpaRepository<PlanDetailModification, Long> {

    public List<PlanDetailModification> findAll();

    @Query("select pdm from PlanDetailModification pdm join User u on pdm.user = u where u.id = (?1)")
    public List<PlanDetailModification> findByUser(Long uID);

}
