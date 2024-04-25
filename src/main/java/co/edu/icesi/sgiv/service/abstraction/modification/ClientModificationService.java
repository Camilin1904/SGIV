package co.edu.icesi.sgiv.service.abstraction.modification;

import co.edu.icesi.sgiv.domain.modification.ClientModification;
import co.edu.icesi.sgiv.service.abstraction.GenericService;

import java.util.List;

public interface ClientModificationService extends GenericService<ClientModification, Long> {
    public List<ClientModification> findAll();

    public List<ClientModification> findByUser(Long uID);
}
