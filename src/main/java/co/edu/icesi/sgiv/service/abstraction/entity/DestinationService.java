package co.edu.icesi.sgiv.service.abstraction.entity;

import co.edu.icesi.sgiv.domain.status.DestinationStatus;
import co.edu.icesi.sgiv.domain.type.DestinationType;
import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import co.edu.icesi.sgiv.dto.status.DestinationStatusDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;

import java.util.List;
import java.util.Optional;

public interface DestinationService extends GenericService<DestinationDTO, Long> {
    public List<DestinationDTO> findAll();


    public List<DestinationDTO> findDestinationsByDestinationTypeName(String dType);

    public List<DestinationDTO> findDestinationsByCode(String code);

    public Optional<DestinationStatusDTO> getStatus(Long DID);

    public List<DestinationDTO> findDestinationsByDestinationType(DestinationType dt);
}
