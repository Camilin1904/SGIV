package co.edu.icesi.sgiv.repository.entity;

import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.status.DestinationStatus;
import co.edu.icesi.sgiv.domain.type.DestinationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DestinationRepository extends JpaRepository<Destination, Long> {

    public List<Destination> findAll();

    @Query("select d from Destination d inner join DestinationType dt on d.type = dt where dt.name = (?1)")
    public List<Destination> findDestinationsByDestinationTypeName(String dType);

    public List<Destination> findDestinationsByCode(String code);

    @Query("select ds from DestinationStatus ds join Destination d where d.id = ?1")
    public Optional<DestinationStatus> getStatus(Long DID);

    @Query("select d from Destination d join DestinationStatus dt where dt = ?1")
    public List<Destination> findDestinationsByDestinationType(DestinationType dt);


}
