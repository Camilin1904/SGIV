package co.edu.icesi.sgiv.repository.type;

import co.edu.icesi.sgiv.domain.type.DestinationType;
import co.edu.icesi.sgiv.domain.type.IdentificationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IdentificationTypeRepository extends JpaRepository<IdentificationType, Long> {

    public List<IdentificationType> findAll();
}
