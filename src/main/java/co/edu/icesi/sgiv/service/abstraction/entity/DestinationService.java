package co.edu.icesi.sgiv.service.abstraction.entity;

import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.status.DestinationStatus;
import co.edu.icesi.sgiv.domain.type.DestinationType;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DestinationService extends GenericService<Destination, Long> {
    public List<Destination> findAll();


    public List<Destination> findDestinationsByDestinationTypeName(String dType);

    public List<Destination> findDestinationsByCode(String code);

    public Optional<DestinationStatus> getStatus(Long DID);

    public List<Destination> findDestinationsByDestinationType(DestinationType dt);
}
