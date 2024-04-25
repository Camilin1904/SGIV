package co.edu.icesi.sgiv.service.abstraction.modification;

import co.edu.icesi.sgiv.domain.modification.PlanDetailModification;
import co.edu.icesi.sgiv.service.abstraction.GenericService;

import java.util.List;

public interface PlanDetailModificationService extends GenericService<PlanDetailModification, Long> {

    public List<PlanDetailModification> findAll();

    public List<PlanDetailModification> findByUser(Long uID);
}
