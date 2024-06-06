package co.edu.icesi.sgiv.repository.entity;

import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.entity.PlanDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlanDetailRepository extends JpaRepository<PlanDetail, Long> {

    public List<PlanDetail> findAll();


    @Query("select d from Destination d join PlanToPlanDetail pd join PlanDetail p where p.id = ?1")
    public List<Destination> getDestinations(Long planDID);



    public Page<PlanDetail> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM plan_detail PD WHERE" +
                   "(:name IS NULL OR LOWER(PD.name) LIKE '%'||LOWER(:name)||'%') AND" +
                   "(:days_upper IS NULL OR PD.number_of_days <= :days_upper) AND" +
                   "(:days_lower IS NULL OR PD.number_of_days >= :days_lower) AND" +
                   "(:nights_upper IS NULL OR PD.number_of_nights <= :nights_upper) AND" +
                   "(:nights_lower IS NULL OR PD.number_of_nights >= :nights_lower) AND" +
                   "(:value_upper IS NULL OR PD.value <= :value_upper) AND" +
                   "(:value_lower IS NULL OR PD.value >= :value_lower) AND" +
                   "(:status IS NULL OR pd.status = :status)", nativeQuery = true)
    public Page<PlanDetail> findByFilter(@Param("name") String name,@Param("days_upper") Integer daysUpper, @Param("days_lower") Integer daysLower,@Param("nights_upper") Integer nightsUpper, @Param("nights_lower") Integer nightsLower, @Param("value_upper") Double valueUpper, @Param("value_lower") Double valueLower, @Param("status") String status, Pageable pageable);

    @Query("SELECT pd " +
            "FROM PlanDetail pd " +
            "JOIN pd.plans p " +
            "GROUP BY pd " +
            "ORDER BY COUNT(p) DESC " +
            "LIMIT 1")
    PlanDetail findMostReservedPlanDetail();

}
