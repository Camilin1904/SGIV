package co.edu.icesi.sgiv.service.abstraction.modification;

import co.edu.icesi.sgiv.dto.modification.DestinationModificationDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;

import java.util.List;

public interface DestinationModificationService extends GenericService<DestinationModificationDTO, Long> {

    public List<DestinationModificationDTO> findAll();

    public List<DestinationModificationDTO> findByUser(Long uID);
}
