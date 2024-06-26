package co.edu.icesi.sgiv.repository.type;

import co.edu.icesi.sgiv.domain.type.DestinationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinationTypeRepository extends JpaRepository<DestinationType, Long> {

    public List<DestinationType> findAll();
}
