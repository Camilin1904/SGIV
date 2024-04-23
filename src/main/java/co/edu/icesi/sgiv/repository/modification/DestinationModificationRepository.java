package co.edu.icesi.sgiv.repository.modification;

import co.edu.icesi.sgiv.domain.modification.ClientModification;
import co.edu.icesi.sgiv.domain.modification.DestinationModification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DestinationModificationRepository extends JpaRepository<DestinationModification, Long> {

    public List<DestinationModification> findAll();

    @Query("select dm from DestinationModification dm join User u on dm.user = u where u.id = (?1)")
    public List<DestinationModification> findByUser(Long uID);
}
