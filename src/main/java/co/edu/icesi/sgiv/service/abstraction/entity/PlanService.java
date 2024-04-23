package co.edu.icesi.sgiv.service.abstraction.entity;

import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.entity.Plan;
import co.edu.icesi.sgiv.domain.entity.PlanDetail;
import co.edu.icesi.sgiv.domain.status.PlanStatus;
import co.edu.icesi.sgiv.service.abstraction.GenericService;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface PlanService extends GenericService<Plan, Long> {

    public List<Plan> findAll();

    public List<Plan> findPlanByClient(Client client);

    public List<Plan> findPlanByStartDateBetween(Date beginning, Date end);

    public List<Plan> findPlanByPlanDetail(PlanDetail planDetail);

    public List<Plan> findByValue(Double value);

    public List<Destination> getDestinations(Long pID);

    public Optional<PlanStatus> getStatus(Long pID);
}
