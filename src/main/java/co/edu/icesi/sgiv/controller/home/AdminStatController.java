package co.edu.icesi.sgiv.controller.home;

import co.edu.icesi.sgiv.controller.auth.AuthResponse;
import co.edu.icesi.sgiv.controller.auth.LoginRequest;
import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import co.edu.icesi.sgiv.service.abstraction.entity.DestinationService;
import co.edu.icesi.sgiv.service.abstraction.entity.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping(value = "/pop_dest", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DestinationDTO> popDest() {

        Optional<Long> popDID = planService.getMostPopularDestination();

        return popDID.map(aLong -> ResponseEntity.ok(destinationService.findByID(aLong).get())).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping(value = "/sale_now", consumes = "application/json", produces = "application/json")
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

        return  ResponseEntity.ok(planService.getTotalEarnings().get()  );

    }




}
