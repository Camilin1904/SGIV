package co.edu.icesi.sgiv.repository.entity;

import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.entity.Plan;
import co.edu.icesi.sgiv.domain.entity.PlanDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


    @Query("select d from Destination d join PlanToPlanDetail join PlanDetail join Plan p where p.id = ?1")
    public List<Destination> getDestinations(Long pID);

    @Query(value = "select p.id from (select d.id, count(d.id) as num_plans from plan p join plan_to_plan_detail ptpd on p.id = ptpd.plan_id join plan_detail pd on ptpd.plan_detail_id = pd.id" +
            "                join destination d on pd.destination = d.id" +
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

    @Query(value = "select pd.id from (select d.id, count(d.id) as num from plan p join plan_to_plan_detail ptpd on p.id = ptpd.plan_id join plan_detail d on ptpd.plan_detail_id = d.id group by d.id order by num desc limit 1) pd"
    , nativeQuery = true)
    public Optional<Long> getMostPopularPlanDetail();



    @Query(value = "SELECT * FROM PLAN P WHERE" +
                   "(:code IS NULL OR LOWER(P.CODE) LIKE '%'||LOWER(:code)||'%') AND" +
                   "(:totalValueM IS NULL OR P.TOTAL_VALUE <= :totalValueM) AND" +
                   "(:totalValueL IS NULL OR P.TOTAL_VALUE >= :totalValueL) AND" +
                   "(:status IS NULL OR P.STATUS = :status)", nativeQuery = true)
    public Page<Plan> findByFilter(@Param("code") String code, @Param("totalValueM") Double tvm,
                                   @Param("totalValueL") Double tvl,
                                   @Param("status") String status, Pageable pageable);

}
