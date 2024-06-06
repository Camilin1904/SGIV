package co.edu.icesi.sgiv.controller.screens.entity;

import co.edu.icesi.sgiv.dto.entity.AccommodationDTO;
import co.edu.icesi.sgiv.dto.entity.HotelDTO;
import co.edu.icesi.sgiv.request.PlanDetailRequest;
import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;
import co.edu.icesi.sgiv.service.abstraction.entity.AccommodationService;
import co.edu.icesi.sgiv.service.abstraction.entity.PlanDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/plan_detail")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class PlanDetailController {
    @Autowired
    private final PlanDetailService planDetailService;
    @Autowired
    private final AccommodationService accommodationService;

    @GetMapping(value = "/get_all")
    public List<PlanDetailDTO> getAll() {
        return planDetailService.findAll();
    }

    @PostMapping(value = "page_plan_detail", produces = "application/json")
    public ResponseEntity<Page<PlanDetailDTO>> pagePlanDetail(@RequestBody PlanDetailRequest planDetailRequest) {
        Pageable pageable = PageRequest.of(planDetailRequest.getPage(),planDetailRequest.getSize());
        System.out.println(planDetailService.findByFilter(planDetailRequest.getName(), planDetailRequest.getDaysUpper(),
                planDetailRequest.getDaysLower(), planDetailRequest.getNightsUpper(),
                planDetailRequest.getNightsLower(),planDetailRequest.getValueUpper(),
                planDetailRequest.getValueLower(), planDetailRequest.getStatus(), pageable));

        return ResponseEntity.ok(planDetailService.findByFilter(planDetailRequest.getName(), planDetailRequest.getDaysUpper(),
                                                                planDetailRequest.getDaysLower(), planDetailRequest.getNightsUpper(),
                                                                planDetailRequest.getNightsLower(),planDetailRequest.getValueUpper(),
                                                                planDetailRequest.getValueLower(), planDetailRequest.getStatus(), pageable));
    }

    @GetMapping(value = "count", produces = "application/json")
    public Long count() {
        return planDetailService.count();
    }

    @RequestMapping(value = "/create", consumes = "application/json")
    public ResponseEntity<?> createPD(@RequestBody PlanDetailDTO planDetailDTO) {
        planDetailDTO.setCreationDate(LocalDateTime.now());
        System.out.println(planDetailDTO);
        try{
            planDetailService.save(planDetailDTO);
            return ResponseEntity.ok(null);
        }
        catch(Exception e){
            System.out.println(e);
            return ResponseEntity.badRequest().body(null);
        }
    }


    @RequestMapping(value = "/create_acc", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createAcc(@RequestBody AccommodationDTO accommodationDTO) {
        try{

            return ResponseEntity.ok(accommodationService.save(accommodationDTO));
        }
        catch(Exception e){
            System.out.println(e);
            return ResponseEntity.badRequest().body(null);
        }
    }

}
