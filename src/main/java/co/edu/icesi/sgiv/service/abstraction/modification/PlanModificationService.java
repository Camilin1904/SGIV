package co.edu.icesi.sgiv.service.abstraction.modification;

import co.edu.icesi.sgiv.dto.modification.PlanModificationDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PlanModificationService extends GenericService<PlanModificationDTO, Long> {

    public List<PlanModificationDTO> findAll();

    public List<PlanModificationDTO> findByUser(Long uID);
}
