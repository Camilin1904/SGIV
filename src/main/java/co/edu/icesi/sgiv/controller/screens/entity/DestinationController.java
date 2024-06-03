package co.edu.icesi.sgiv.controller.screens.entity;

import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.mapper.entity.DestinationMapper;
import co.edu.icesi.sgiv.request.DestinationRequest;
import co.edu.icesi.sgiv.domain.resources.DestinationImage;
import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import co.edu.icesi.sgiv.dto.resources.DestinationImageDTO;
import co.edu.icesi.sgiv.dto.type.DestinationTypeDTO;
import co.edu.icesi.sgiv.mapper.resources.DestinationImageMapper;
import co.edu.icesi.sgiv.service.abstraction.entity.DestinationService;
import co.edu.icesi.sgiv.service.abstraction.resources.DestinationImageService;
import co.edu.icesi.sgiv.service.abstraction.type.DestinationTypeService;
import co.edu.icesi.sgiv.service.implementation.resources.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    private DestinationTypeService destinationTypeService;

    @Autowired
    private ImageService imageService;



    private final DestinationImageMapper destinationImageMapper = DestinationImageMapper.INSTANCE;
    private final DestinationMapper destinationMapper = DestinationMapper.INSTANCE;


    //@PreAuthorize("hasAuthority('Admin')||hasAuthority('Advisor')")
    @PostMapping(value = "/dest_img", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<DestinationImageDTO>> destImg(@RequestBody FetchRequest request) {

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
    public ResponseEntity<List<DestinationDTO>> page_dest(@RequestBody DestinationRequest destinationRequest) {
        Pageable pageable = PageRequest.of(destinationRequest.getPage(),destinationRequest.getSize());

        Page<DestinationDTO> destinations = destinationService.findByFilter(destinationRequest.getName(), destinationRequest.getCode(),
                                                                            destinationRequest.getStatus(), destinationRequest.getType(),
                                                                            pageable);

        System.out.println(destinations);
        return ResponseEntity.ok(destinations.toList());
    }


    @GetMapping(value = "/dest_count", produces = "application/json")
    public ResponseEntity<Long> dest_count() {
        return ResponseEntity.ok(destinationService.count());
    }


    @GetMapping(value = "/getInfo", produces = "application/json")
    public ResponseEntity<List<DestinationTypeDTO>> getInfo() {
        List<DestinationTypeDTO> types = destinationTypeService.findAll();

        return ResponseEntity.ok(types);
    }

    @PreAuthorize("hasAuthority('Admin')||hasAuthority('Advisor')")
    @PostMapping(value = "/upload_image", produces = "application/json")
    public ResponseEntity<?> upload(@RequestParam Long destinationId, @RequestParam MultipartFile image) throws Exception {
        String imageURL = imageService.upload(image);
        Optional<DestinationDTO> destinationDTO = destinationService.findByID(destinationId);
        if(destinationDTO.isPresent()){
            Destination destination = destinationMapper.toEntity(destinationDTO.get());
            DestinationImage destinationImage = new DestinationImage();
            destinationImage.setDestination(destination);
            destinationImage.setImage(imageURL);
            destinationImageService.save(destinationImage);
            return ResponseEntity.ok(imageURL);
        }
        return ResponseEntity.status(401).body("The destination does not exists");
    }

}
