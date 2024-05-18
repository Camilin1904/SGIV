package co.edu.icesi.sgiv.service.abstraction.type;

import co.edu.icesi.sgiv.domain.type.DestinationType;
import co.edu.icesi.sgiv.dto.type.DestinationTypeDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.stereotype.Service;

@Service
public interface DestinationTypeService extends GenericService<DestinationTypeDTO, Long> {
}
