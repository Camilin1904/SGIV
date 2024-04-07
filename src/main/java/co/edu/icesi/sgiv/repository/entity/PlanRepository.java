package co.edu.icesi.sgiv.repository.entity;

import co.edu.icesi.sgiv.domain.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

    public interface PlanRepository  extends JpaRepository<Plan, Long> {

    public List<Plan> findAll();

    public List<Plan> findPlanById(Long id);

    public List<Plan> findPlanByClient(Long client);

    public List<Plan> findPlanByStartDateBetween(Date beginning, Date end);

    public List<Plan> findPlanByPlanDetail(Long planDetail);

    @Query("select p from Plan p inner join PlanDetail pd on p.planDetail = pd where pd.value = (?1) ")
    public List<Plan> findByValue(Double value);
}
