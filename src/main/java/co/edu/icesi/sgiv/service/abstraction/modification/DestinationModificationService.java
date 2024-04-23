package co.edu.icesi.sgiv.service.abstraction.modification;

import co.edu.icesi.sgiv.domain.modification.DestinationModification;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DestinationModificationService extends GenericService<DestinationModification, Long> {

    public List<DestinationModification> findAll();

    public List<DestinationModification> findByUser(Long uID);
}
