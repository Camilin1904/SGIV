package co.edu.icesi.sgiv.controller.screens.entity;

import co.edu.icesi.sgiv.dto.entity.ClientDTO;
import co.edu.icesi.sgiv.dto.entity.HotelDTO;
import co.edu.icesi.sgiv.dto.resources.HotelImageDTO;
import co.edu.icesi.sgiv.mapper.entity.HotelMapper;
import co.edu.icesi.sgiv.mapper.resources.HotelImageMapper;
import co.edu.icesi.sgiv.request.HotelRequest;
import co.edu.icesi.sgiv.service.abstraction.entity.HotelService;
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
@RequestMapping("/hotel")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class HotelController {

    @Autowired
    private final HotelService hotelService;

    private final HotelMapper hotelMapper = HotelMapper.INSTANCE;

    private final HotelImageMapper hotelImageMapper = HotelImageMapper.INSTANCE;

    @PostMapping(value = "/hotel_img", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<HotelImageDTO>> hotelImg(@RequestBody FetchRequest request) {

        Long hotelID = request.getId();

        List<HotelImageDTO> images = hotelService.getImages(hotelID);

        return ResponseEntity.ok(images);

    }

    @PostMapping(value = "/page_hotel", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<HotelDTO>> page_hotel(@RequestBody HotelRequest hotelRequest) {
        Pageable pageable = PageRequest.of(hotelRequest.getPage(),hotelRequest.getSize());

        Page<HotelDTO> hotels = hotelService.findByFilter(pageable, hotelRequest.getName(), hotelRequest.getAddress(),
                hotelRequest.getStatus(), hotelRequest.getDID());

        System.out.println(hotels);
        return ResponseEntity.ok(hotels.toList());
    }

    @PostMapping(value = "/countFilter", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> countFilter(@RequestBody HotelRequest hotelRequest) {
        Pageable pageable = PageRequest.of(hotelRequest.getPage(),hotelRequest.getSize());

        Page<HotelDTO> hotels = hotelService.findByFilter(pageable, hotelRequest.getName(), hotelRequest.getAddress(),
                hotelRequest.getStatus(), hotelRequest.getDID());

        System.out.println(hotels);
        return ResponseEntity.ok(hotels.getTotalPages());
    }


    @GetMapping(value = "/hotel_count", produces = "application/json")
    public ResponseEntity<Long> hotel_count() {
        return ResponseEntity.ok(hotelService.count());
    }

    @RequestMapping(value = "/create", consumes = "application/json")
    public ResponseEntity<?> createClient(@RequestBody HotelDTO hotelDTO) {
        try{
            hotelService.save(hotelDTO);
            return ResponseEntity.ok(null);
        }
        catch(Exception e){
            System.out.println(e);
            return ResponseEntity.badRequest().body(null);
        }
    }


    /*@PreAuthorize("hasAuthority('Admin')||hasAuthority('Advisor')")
    @PostMapping(value = "/upload_image", produces = "application/json")
    public ResponseEntity<?> upload(@RequestParam Long hotelId, @RequestParam MultipartFile image) throws Exception {
        String imageURL = imageService.upload(image);
        Optional<HotelDTO> hotelDTO = hotelService.findByID(hotelId);
        if(hotelDTO.isPresent()){
            Hotel hotel = hotelMapper.toEntity(hotelDTO.get());
            HotelImage hotelImage = new HotelImage();
            hotelImage.setHotel(hotel);
            hotelImage.setImage(imageURL);
            hotelImageService.save(hotelImage);
            return ResponseEntity.ok(imageURL);
        }
        return ResponseEntity.status(401).body("The hotel does not exists");
    }
*/

}
