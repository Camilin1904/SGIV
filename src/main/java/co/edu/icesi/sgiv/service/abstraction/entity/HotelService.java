package co.edu.icesi.sgiv.service.abstraction.entity;

import co.edu.icesi.sgiv.domain.entity.Hotel;
import co.edu.icesi.sgiv.dto.entity.AccommodationDTO;
import co.edu.icesi.sgiv.dto.entity.HotelDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface HotelService extends GenericService<HotelDTO, Long> {

    public Page<HotelDTO> findAll(Pageable page);

}
