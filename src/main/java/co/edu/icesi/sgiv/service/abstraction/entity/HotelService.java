package co.edu.icesi.sgiv.service.abstraction.entity;

import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.entity.Hotel;
import co.edu.icesi.sgiv.domain.resources.DestinationImage;
import co.edu.icesi.sgiv.domain.resources.HotelImage;
import co.edu.icesi.sgiv.dto.entity.AccommodationDTO;
import co.edu.icesi.sgiv.dto.entity.HotelDTO;
import co.edu.icesi.sgiv.dto.resources.HotelImageDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService extends GenericService<HotelDTO, Long> {

    public Page<HotelDTO> findAll(Pageable page);

    public List<HotelImageDTO> getImages(Long id);

    public Page<HotelDTO> findByFilter(Pageable pageable,String name, String address, String status, Long dID);

}
