package co.edu.icesi.sgiv.controller.screens;

import co.edu.icesi.sgiv.domain.resources.DestinationImage;
import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import co.edu.icesi.sgiv.dto.resources.DestinationImageDTO;
import co.edu.icesi.sgiv.mapper.resources.DestinationImageMapper;
import co.edu.icesi.sgiv.service.abstraction.entity.DestinationService;
import co.edu.icesi.sgiv.service.abstraction.entity.PlanService;
import co.edu.icesi.sgiv.service.abstraction.resources.DestinationImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.Optional;

@RestController
@RequestMapping("/destination")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class DestinationController {


    @Autowired
    private DestinationService destinationService;

    @Autowired
    private DestinationImageService destinationImageService;

    private DestinationImageMapper destinationImageMapper = DestinationImageMapper.INSTANCE;

    @PreAuthorize("hasAuthority('Admin')||hasAuthority('Advisor')")
    @GetMapping(value = "/dest_img", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<DestinationImageDTO>> destiImg(@RequestBody FetchRequest request) {

        Long destID = request.getId();

        List<DestinationImageDTO> images = destinationImageMapper.toDTO(destinationService.getImages(destID));

        return ResponseEntity.ok(images);

    }

    @PreAuthorize("hasAuthority('Viewer')||hasAuthority('Advisor')")
    @GetMapping(value = "/rand_image", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DestinationImageDTO> rand_image() {

        List<DestinationImage> destinationImages = destinationImageService.findAll();
        
        int imageIndex = (int) (Math.random() * destinationImages.size());


        DestinationImageDTO image = destinationImageMapper.toDTO(destinationImages.get(imageIndex));

        return ResponseEntity.ok(image);

    }




}
