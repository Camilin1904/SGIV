package co.edu.icesi.sgiv.service.abstraction.modification;

import co.edu.icesi.sgiv.domain.modification.DestinationModification;
import co.edu.icesi.sgiv.service.abstraction.GenericService;

import java.util.List;

public interface DestinationModificationService extends GenericService<DestinationModification, Long> {

    public List<DestinationModification> findAll();

    public List<DestinationModification> findByUser(Long uID);
}
