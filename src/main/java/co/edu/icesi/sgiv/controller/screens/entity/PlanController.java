package co.edu.icesi.sgiv.controller.screens.entity;


import co.edu.icesi.sgiv.request.PlanRequest;
import co.edu.icesi.sgiv.service.abstraction.entity.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plan")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class PlanController {


    @Autowired
    private final PlanService planService;


    @PostMapping(value = "/page_plan", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> pagePlan(@RequestBody PlanRequest planRequest) {
        Pageable pageable = PageRequest.of(planRequest.getPage(), planRequest.getSize());
        return ResponseEntity.ok(planService.findByFilter(planRequest.getCode(), planRequest.getTvm(),
                                                          planRequest.getTvl(),
                                                          planRequest.getStatus(), pageable));
    }

    @GetMapping(value = "/count", produces = "application/json")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(planService.count());
    }
}
