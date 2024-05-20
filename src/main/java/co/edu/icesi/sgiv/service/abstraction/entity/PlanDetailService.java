package co.edu.icesi.sgiv.service.abstraction.entity;

import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlanDetailService extends GenericService<PlanDetailDTO, Long> {

    public List<PlanDetailDTO> findAll();

    public List<DestinationDTO> getDestinations(Long planDID);

    public Page<PlanDetailDTO> findAll(Pageable pageable);

}
