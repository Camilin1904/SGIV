package co.edu.icesi.sgiv.controller.screens;


import co.edu.icesi.sgiv.dto.entity.PlanDTO;
import co.edu.icesi.sgiv.service.abstraction.entity.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<Page<PlanDTO>> pagePlan(@RequestParam int size, @RequestParam int page) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(planService.findAll(pageable));
    }

    @GetMapping(value = "/count", produces = "application/json")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(planService.count());
    }
}
