package co.edu.icesi.sgiv.controller.screens;

import co.edu.icesi.sgiv.controller.screens.requests.DestinationRequest;
import co.edu.icesi.sgiv.domain.resources.DestinationImage;
import co.edu.icesi.sgiv.dto.DestTypeStatusDTO;
import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import co.edu.icesi.sgiv.dto.resources.DestinationImageDTO;
import co.edu.icesi.sgiv.dto.status.DestinationStatusDTO;
import co.edu.icesi.sgiv.dto.type.DestinationTypeDTO;
import co.edu.icesi.sgiv.mapper.resources.DestinationImageMapper;
import co.edu.icesi.sgiv.service.abstraction.entity.DestinationService;
import co.edu.icesi.sgiv.service.abstraction.resources.DestinationImageService;
import co.edu.icesi.sgiv.service.abstraction.status.DestinationStatusService;
import co.edu.icesi.sgiv.service.abstraction.type.DestinationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destination")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class DestinationController {


    @Autowired
    private DestinationService destinationService;

    @Autowired
    private DestinationImageService destinationImageService;

    @Autowired
    private DestinationTypeService destinationTypeService;

    @Autowired
    private DestinationStatusService destinationStatusService;



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

    @PostMapping(value = "/page_dest", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Page<DestinationDTO>> page_dest(@RequestBody DestinationRequest destinationRequest) {
        Pageable pageable = PageRequest.of(destinationRequest.getPage(),destinationRequest.getSize());

        Page<DestinationDTO> destinations = destinationService.findByFilter(destinationRequest.getName(), destinationRequest.getCode(),
                                                                            destinationRequest.getStatus(), destinationRequest.getType(),
                                                                            pageable);
        return ResponseEntity.ok(destinations);
    }


    @GetMapping(value = "/dest_count", produces = "application/json")
    public ResponseEntity<Long> dest_count() {
        return ResponseEntity.ok(destinationService.count());
    }


    @GetMapping(value = "/getInfo", produces = "application/json")
    public ResponseEntity<DestTypeStatusDTO> getInfo() {
        DestTypeStatusDTO dto = new DestTypeStatusDTO();
        List<DestinationTypeDTO> types = destinationTypeService.findAll();
        List<DestinationStatusDTO> statuses = destinationStatusService.findAll();

        dto.setDestinationStatus(statuses);
        dto.setDestinationType(types);

        return ResponseEntity.ok(dto);
    }

}
