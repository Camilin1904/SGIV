package co.edu.icesi.sgiv.repository.entity;

import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.entity.Plan;
import co.edu.icesi.sgiv.domain.entity.PlanDetail;
import co.edu.icesi.sgiv.domain.status.PlanStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    @Query ("select ps from PlanStatus ps join Plan p where p.id = ?1")
    public Optional<PlanStatus> getStatus(Long pID);

    @Query(value = "select p.id from (select d.id, count(d.id) as num_plans from plan p join plan_detail pd on p.plan_detail_id = pd.id" +
            "                join plan_detail_destination pdd on pdd.plan_detail_id = pd.id" +
            "                join destination d on pdd.destination_id = d.id" +
            "                group by d.id order by num_plans desc limit 1) p",
    nativeQuery = true)
    public Optional<Long> getMostPopularDestination();

    @Query(value = "select * from plan where plan.creation_date = :date", nativeQuery = true)
    public List<Plan> findByCreationDate(@Param("date") Date date);

    @Query(value = "select count(*) from plan where plan.creation_date = :date", nativeQuery = true)
    public Long countByCreationDate(@Param("date")Date date);

    @Query(value = "select p.id from (select d.id, count(d.id) as num_plans from plan p join plan_detail pd on p.plan_detail_id = pd.id" +
            "                join plan_detail_destination pdd on pdd.plan_detail_id = pd.id" +
            "                join destination d on pdd.destination_id = d.id" +
            "                group by d.id order by num_plans limit 1) p",
            nativeQuery = true)
    public Optional<Long> getLeastPopularDestination();

    @Query(value = "select sum(p.total_value)from plan p", nativeQuery = true)
    public Optional<Long> getTotalEarnings();

}
