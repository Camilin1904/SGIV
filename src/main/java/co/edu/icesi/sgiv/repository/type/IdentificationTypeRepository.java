package co.edu.icesi.sgiv.repository.type;

import co.edu.icesi.sgiv.domain.type.IdentificationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IdentificationTypeRepository extends JpaRepository<IdentificationType, Long> {

    public List<IdentificationType> findAll();
}
