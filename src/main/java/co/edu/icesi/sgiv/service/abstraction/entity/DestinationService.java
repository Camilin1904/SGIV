package co.edu.icesi.sgiv.service.abstraction.entity;

import co.edu.icesi.sgiv.domain.resources.DestinationImage;
import co.edu.icesi.sgiv.domain.type.DestinationType;
import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DestinationService extends GenericService<DestinationDTO, Long> {
    public List<DestinationDTO> findAll();


    public List<DestinationDTO> findDestinationsByDestinationTypeName(String dType);

    public List<DestinationDTO> findDestinationsByCode(String code);

    public List<DestinationDTO> findDestinationsByDestinationType(DestinationType dt);

    public List<DestinationImage> getImages(Long id);

    public Page<DestinationDTO> findAll(Pageable pageable);

    public long count();

    public Page<DestinationDTO> findByFilter(String name, String code, String status, Long type, Pageable pageable);

}
