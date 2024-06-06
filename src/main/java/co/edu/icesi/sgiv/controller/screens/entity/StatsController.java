package co.edu.icesi.sgiv.controller.screens.entity;

import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.domain.entity.PlanDetail;
import co.edu.icesi.sgiv.dto.entity.ClientDTO;
import co.edu.icesi.sgiv.request.PlanDetailRequest;
import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;
import co.edu.icesi.sgiv.service.abstraction.entity.ClientService;
import co.edu.icesi.sgiv.service.abstraction.entity.PlanDetailService;
import co.edu.icesi.sgiv.service.abstraction.entity.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stats")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class StatsController {
    private final PlanService planService;
    private final PlanDetailService planDetailService;
    private final ClientService clientService;

    @GetMapping("/most-reserved-plan-detail")
    public PlanDetailDTO getMostReservedPlanDetail() {
        return planDetailService.getMostReservedPlanDetail();
    }

    @GetMapping("/count-by-date-last-30-days")
    public List<Map<String, Object>> getPlansCountByDateLast30Days() {
        return planService.getPlansCountByDateLast30Days().stream()
                .map(result -> Map.of(
                        "date", result[0],
                        "count", result[1]
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/top-5-clients")
    public List<ClientDTO> getTop5ClientsWithMostReservations() {
        return clientService.getTop5ClientsWithMostReservations();
    }
}
