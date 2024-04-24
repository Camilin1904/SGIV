package co.edu.icesi.sgiv.repository.entity;

import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.entity.Plan;
import co.edu.icesi.sgiv.domain.entity.PlanDetail;
import co.edu.icesi.sgiv.domain.status.PlanStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface PlanRepository  extends JpaRepository<Plan, Long> {

    public List<Plan> findAll();


    public List<Plan> findPlanByClient(Client client);

    public List<Plan> findPlanByStartDateBetween(Date beginning, Date end);

    public List<Plan> findPlanByPlanDetail(PlanDetail planDetail);

    @Query("select p from Plan p inner join PlanDetail pd on p.planDetail = pd where pd.value = (?1) ")
    public List<Plan> findByValue(Double value);

    @Query("select d from Destination d join PlanDetailDestination join PlanDetail join Plan p where p.id = ?1")
    public List<Destination> getDestinations(Long pID);

    @Query ("select ps from PlanStatusDTO join Plan p where p.id = ?1")
    public Optional<PlanStatus> getStatus(Long pID);
}
