package co.edu.icesi.sgiv.repository.entity;

import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.domain.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DestinationRepository extends JpaRepository<Destination, Long> {

    public List<Destination> findAll();

    public Optional<Destination> findById(Long id);

    @Query("select d from Destination d inner join DestinationType dt on d.type = dt where dt.name = (?1)")
    public List<Destination> findDestinationsByDestinationTypeName(String dType);

    public List<Destination> findDestinationsByCode(String code);


}
