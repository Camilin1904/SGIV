package co.edu.icesi.sgiv.service.abstraction.modification;

import co.edu.icesi.sgiv.dto.modification.PlanDetailModificationDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;

import java.util.List;

public interface PlanDetailModificationService extends GenericService<PlanDetailModificationDTO, Long> {

    public List<PlanDetailModificationDTO> findAll();

    public List<PlanDetailModificationDTO> findByUser(Long uID);
}
