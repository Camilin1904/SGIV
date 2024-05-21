package co.edu.icesi.sgiv.controller.screens.entity;

import co.edu.icesi.sgiv.request.PlanDetailRequest;
import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;
import co.edu.icesi.sgiv.service.abstraction.entity.PlanDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan_detail")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class PlanDetailController {
    @Autowired
    private final PlanDetailService planDetailService;

    @GetMapping(value = "/get_all")
    public List<PlanDetailDTO> getAll() {
        return planDetailService.findAll();
    }

    @PostMapping(value = "page_plan_detail", produces = "application/json")
    public ResponseEntity<List<PlanDetailDTO>> pagePlanDetail(@RequestBody PlanDetailRequest planDetailRequest) {
        Pageable pageable = PageRequest.of(planDetailRequest.getPage(),planDetailRequest.getSize());

        return ResponseEntity.ok(planDetailService.findByFilter(planDetailRequest.getName(), planDetailRequest.getDaysUpper(),
                                                                planDetailRequest.getDaysLower(), planDetailRequest.getNightsUpper(),
                                                                planDetailRequest.getNightsLower(),planDetailRequest.getValueUpper(),
                                                                planDetailRequest.getValueLower(), planDetailRequest.getStatus(), pageable).toList());
    }

    @GetMapping(value = "count", produces = "application/json")
    public Long count() {
        return planDetailService.count();
    }


}
