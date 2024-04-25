package co.edu.icesi.sgiv.service.abstraction.modification;

import co.edu.icesi.sgiv.domain.modification.PlanModification;
import co.edu.icesi.sgiv.service.abstraction.GenericService;

import java.util.List;

public interface PlanModificationService extends GenericService<PlanModification, Long> {

    public List<PlanModification> findAll();

    public List<PlanModification> findByUser(Long uID);
}
