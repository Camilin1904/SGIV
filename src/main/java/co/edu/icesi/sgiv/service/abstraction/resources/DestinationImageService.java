package co.edu.icesi.sgiv.service.abstraction.resources;

import co.edu.icesi.sgiv.domain.resources.DestinationImage;
import co.edu.icesi.sgiv.dto.resources.DestinationImageDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DestinationImageService extends GenericService<DestinationImage, Long> {
    public List<DestinationImageDTO> findByDestinationId(Long id);
}
