package co.edu.icesi.sgiv.repository.entity;

import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.entity.PlanDetail;
import co.edu.icesi.sgiv.domain.status.PlanDetailStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlanDetailRepository extends JpaRepository<PlanDetail, Long> {

    public List<PlanDetail> findAll();


    @Query("select d from Destination d join PlanDetailDestination pd join PlanDetail p where p.id = ?1")
    public List<Destination> getDestinations(Long planDID);

    @Query("select pds from PlanDetailStatus pds join PlanDetail p where p.id = ?1")
    public Optional<PlanDetailStatus> getStatus(Long PlanDID);


}
