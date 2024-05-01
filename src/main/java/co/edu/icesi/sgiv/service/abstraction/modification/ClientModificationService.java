package co.edu.icesi.sgiv.service.abstraction.modification;

import co.edu.icesi.sgiv.dto.modification.ClientModificationDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ClientModificationService extends GenericService<ClientModificationDTO, Long> {
    public List<ClientModificationDTO> findAll();

    public List<ClientModificationDTO> findByUser(Long uID);
}
