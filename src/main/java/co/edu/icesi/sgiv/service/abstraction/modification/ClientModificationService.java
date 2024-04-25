package co.edu.icesi.sgiv.service.abstraction.modification;

import co.edu.icesi.sgiv.dto.modification.ClientModificationDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;

import java.util.List;

public interface ClientModificationService extends GenericService<ClientModificationDTO, Long> {
    public List<ClientModificationDTO> findAll();

    public List<ClientModificationDTO> findByUser(Long uID);
}
