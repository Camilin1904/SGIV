package co.edu.icesi.sgiv.service.abstraction.entity;


import co.edu.icesi.sgiv.domain.status.ClientStatus;
import co.edu.icesi.sgiv.dto.entity.ClientDTO;
import co.edu.icesi.sgiv.dto.status.ClientStatusDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ClientService extends GenericService<ClientDTO, Long> {


    public List<ClientDTO> findClientsByIdentificationNumber(String id_num);

    public List<ClientDTO> findClientsByGender(String gender);

    public List<ClientDTO> findAll();

    public List<ClientDTO> findClientsByFirstName(String name);

    public List<ClientDTO> findClientsByFirstAndLastName(String name, String surname);

    public Optional<ClientStatusDTO> getStatus(Long cID);
}
