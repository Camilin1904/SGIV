package co.edu.icesi.sgiv.service.abstraction.entity;

import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;
import co.edu.icesi.sgiv.dto.entity.PlanToPlanDetailDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PlanToPlanDetailService extends GenericService<PlanToPlanDetailDTO, Long> {

    public Page<PlanToPlanDetailDTO> findAll(Pageable pageable);

}
