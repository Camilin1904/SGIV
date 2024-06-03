package co.edu.icesi.sgiv.controller.screens.entity;

import co.edu.icesi.sgiv.dto.entity.HotelDTO;
import co.edu.icesi.sgiv.dto.entity.TransportationDTO;
import co.edu.icesi.sgiv.mapper.entity.TransportationMapper;
import co.edu.icesi.sgiv.request.HotelRequest;
import co.edu.icesi.sgiv.request.TransportationRequest;
import co.edu.icesi.sgiv.service.abstraction.entity.TransportationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transportation")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class TransportationController {

    @Autowired
    TransportationService transportationService;

    final TransportationMapper transportationMapper = TransportationMapper.INSTANCE;

    @PostMapping(value = "/page_transportation", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<TransportationDTO>> page_meal(@RequestBody TransportationRequest transportationRequest) {
        Pageable pageable = PageRequest.of(transportationRequest.getPage(),transportationRequest.getSize());

        Page<TransportationDTO> transportation = transportationService.findByFilter(transportationRequest.getName(),
                transportationRequest.getStatus(), pageable);

        return ResponseEntity.ok(transportation.toList());
    }

    @GetMapping(value = "/transportation_count", produces = "application/json")
    public ResponseEntity<Long> transportation_count() {
        return ResponseEntity.ok(transportationService.count());
    }

}
