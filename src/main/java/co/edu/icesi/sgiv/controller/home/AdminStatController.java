package co.edu.icesi.sgiv.controller.home;

import co.edu.icesi.sgiv.domain.entity.PlanDetail;
import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;
import co.edu.icesi.sgiv.service.abstraction.entity.DestinationService;
import co.edu.icesi.sgiv.service.abstraction.entity.PlanDetailService;
import co.edu.icesi.sgiv.service.abstraction.entity.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Optional;

@RestController
@RequestMapping("/stat")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class AdminStatController {

    @Autowired
    public DestinationService destinationService;
    @Autowired
    public PlanService planService;

    @Autowired
    private PlanDetailService planDetailService;

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping(value = "/pop_dest", produces = "application/json")
    public ResponseEntity<?> popDest() {
        System.out.println("HOLAAAA");
        Optional<Long> popDID = planService.getMostPopularDestination();

        return popDID.map(aLong -> ResponseEntity.ok(destinationService.findByID(aLong).get())).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping(value = "/sale_now", produces = "application/json")
    public ResponseEntity<Long> saleNow() {

        return  ResponseEntity.ok(planService.countByCreationDate(new Date(System.currentTimeMillis())));

    }

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping(value = "/not_pop_dest", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DestinationDTO> notPopDest() {

        Optional<Long> popDID = planService.getLeastPopularDestination();

        return popDID.map(aLong -> ResponseEntity.ok(destinationService.findByID(aLong).get())).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping(value = "/tot_earn", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Long> totEarn() {

        return  ResponseEntity.ok(planService.getTotalEarnings().get());

    }


    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping(value = "/pop_plan", produces = "application/json")
    public ResponseEntity<?> pop_plan() {

        Optional<Long> popPlan = planService.getMostPopularPlanDetail();

        return popPlan.map(aLong -> ResponseEntity.ok(planDetailService.findByID(aLong).get())).orElseGet(() -> ResponseEntity.notFound().build());

    }




}
