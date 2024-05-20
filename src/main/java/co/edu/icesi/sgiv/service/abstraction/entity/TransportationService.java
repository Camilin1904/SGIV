package co.edu.icesi.sgiv.service.abstraction.entity;

import co.edu.icesi.sgiv.domain.entity.Transportation;
import co.edu.icesi.sgiv.dto.entity.PlanDTO;
import co.edu.icesi.sgiv.dto.entity.TransportationDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransportationService extends GenericService<TransportationDTO, Long> {

    public Page<TransportationDTO> findAll(Pageable pageable);

}
