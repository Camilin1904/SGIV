package co.edu.icesi.sgiv.service.abstraction.resources;

import co.edu.icesi.sgiv.domain.resources.DestinationImage;
import co.edu.icesi.sgiv.dto.resources.DestinationImageDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;

import java.util.List;

public interface DestinationImageService extends GenericService<DestinationImage, Long> {
    public List<DestinationImageDTO> findByDestinationId(Long id);
}
