package co.edu.icesi.sgiv.controller.screens.entity;

import co.edu.icesi.sgiv.domain.entity.Hotel;
import co.edu.icesi.sgiv.domain.resources.HotelImage;
import co.edu.icesi.sgiv.domain.resources.HotelImage;
import co.edu.icesi.sgiv.dto.entity.HotelDTO;
import co.edu.icesi.sgiv.dto.resources.HotelImageDTO;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<HotelDTO>> page_dest(@RequestBody HotelRequest hotelRequest) {
        Pageable pageable = PageRequest.of(hotelRequest.getPage(),hotelRequest.getSize());

        Page<HotelDTO> hotels = hotelService.findByFilter(pageable, hotelRequest.getName(), hotelRequest.getAddress(),
                hotelRequest.getStatus());

        System.out.println(hotels);
        return ResponseEntity.ok(hotels.toList());
    }


    @GetMapping(value = "/hotel_count", produces = "application/json")
    public ResponseEntity<Long> hotel_count() {
        return ResponseEntity.ok(hotelService.count());
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
