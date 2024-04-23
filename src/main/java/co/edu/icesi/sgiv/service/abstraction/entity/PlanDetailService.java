package co.edu.icesi.sgiv.service.abstraction.entity;

import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.entity.PlanDetail;
import co.edu.icesi.sgiv.domain.status.PlanDetailStatus;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlanDetailService extends GenericService<PlanDetail, Long> {

    public List<PlanDetail> findAll();

    public List<Destination> getDestinations(Long planDID);

    public Optional<PlanDetailStatus> getStatus(Long PlanDID);
}
