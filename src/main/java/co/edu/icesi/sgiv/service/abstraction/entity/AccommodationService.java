package co.edu.icesi.sgiv.service.abstraction.entity;

import co.edu.icesi.sgiv.dto.entity.AccommodationDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccommodationService extends GenericService<AccommodationDTO, Long> {
    public Page<AccommodationDTO> findAll(Pageable page);
}
