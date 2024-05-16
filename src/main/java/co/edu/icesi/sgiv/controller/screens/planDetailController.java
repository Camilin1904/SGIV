package co.edu.icesi.sgiv.controller.screens;

import co.edu.icesi.sgiv.domain.entity.PlanDetail;
import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;
import co.edu.icesi.sgiv.service.abstraction.entity.PlanDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plan_detail")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class planDetailController {
    @Autowired
    private final PlanDetailService planDetailService;

    @GetMapping(value = "/get_all")
    public List<PlanDetailDTO> getAll() {
        return planDetailService.findAll();
    }


}
