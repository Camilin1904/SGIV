package co.edu.icesi.sgiv.service.abstraction.entity;

import co.edu.icesi.sgiv.domain.entity.Plan;
import co.edu.icesi.sgiv.dto.entity.ClientDTO;
import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import co.edu.icesi.sgiv.dto.entity.PlanDTO;
import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;
import co.edu.icesi.sgiv.dto.status.PlanStatusDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    public Optional<Long> getMostPopularDestination();

    public List<Plan> findByCreationDate(Date date);

    public Long countByCreationDate(Date date);

    public Optional<Long> getLeastPopularDestination();

    public Optional<Long> getTotalEarnings();

    public Optional<Long> getMostPopularPlanDetail();

    public Page<PlanDTO> findAll(Pageable pageable);

    public Long countAll();


}
