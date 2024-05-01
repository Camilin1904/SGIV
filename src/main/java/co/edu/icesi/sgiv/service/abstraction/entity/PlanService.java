package co.edu.icesi.sgiv.service.abstraction.entity;

import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.entity.PlanDetail;
import co.edu.icesi.sgiv.domain.status.PlanStatus;
import co.edu.icesi.sgiv.dto.entity.ClientDTO;
import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import co.edu.icesi.sgiv.dto.entity.PlanDTO;
import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;
import co.edu.icesi.sgiv.dto.status.PlanStatusDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
@Service
public interface PlanService extends GenericService<PlanDTO, Long> {

    public List<PlanDTO> findAll();

    public List<PlanDTO> findPlanByClient(ClientDTO clientSTO);

    public List<PlanDTO> findPlanByStartDateBetween(Date beginning, Date end);

    public List<PlanDTO> findPlanByPlanDetail(PlanDetailDTO planDetailDTO);

    public List<PlanDTO> findByValue(Double value);

    public List<DestinationDTO> getDestinations(Long pID);

    public Optional<PlanStatusDTO> getStatus(Long pID);
}
