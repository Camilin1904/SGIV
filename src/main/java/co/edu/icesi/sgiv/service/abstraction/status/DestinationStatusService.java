package co.edu.icesi.sgiv.service.abstraction.status;

import co.edu.icesi.sgiv.domain.status.DestinationStatus;
import co.edu.icesi.sgiv.dto.status.DestinationStatusDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.stereotype.Service;

@Service
public interface DestinationStatusService extends GenericService<DestinationStatusDTO, Long> {
}
