package co.edu.icesi.sgiv.service.abstraction.entity;

import co.edu.icesi.sgiv.domain.entity.Meals;
import co.edu.icesi.sgiv.dto.entity.HotelDTO;
import co.edu.icesi.sgiv.dto.entity.MealsDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface MealsService extends GenericService<MealsDTO, Long> {
    public Page<MealsDTO> findAll(Pageable page);
    public Page<MealsDTO> findByFilter(@Param("name") String name, @Param("status") String status, Pageable page);


}
