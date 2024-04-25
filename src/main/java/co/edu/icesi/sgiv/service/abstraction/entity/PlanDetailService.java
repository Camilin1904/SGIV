package co.edu.icesi.sgiv.service.abstraction.entity;

import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.status.PlanDetailStatus;
import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;
import co.edu.icesi.sgiv.dto.status.PlanDetailStatusDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;

import java.util.List;
import java.util.Optional;

public interface PlanDetailService extends GenericService<PlanDetailDTO, Long> {

    public List<PlanDetailDTO> findAll();

    public List<DestinationDTO> getDestinations(Long planDID);

    public Optional<PlanDetailStatusDTO> getStatus(Long PlanDID);
}
