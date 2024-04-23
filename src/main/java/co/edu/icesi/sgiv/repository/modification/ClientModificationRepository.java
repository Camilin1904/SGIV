package co.edu.icesi.sgiv.repository.modification;

import co.edu.icesi.sgiv.domain.modification.ClientModification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClientModificationRepository extends JpaRepository<ClientModification, Long> {

    public List<ClientModification> findAll();


    @Query("select cm from ClientModification cm join User u on cm.user = u where u.id = (?1)")
    public List<ClientModification> findByUser(Long uID);

}
