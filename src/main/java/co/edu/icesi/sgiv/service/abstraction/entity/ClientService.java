package co.edu.icesi.sgiv.service.abstraction.entity;


import co.edu.icesi.sgiv.dto.entity.ClientDTO;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService extends GenericService<ClientDTO, Long> {


    public List<ClientDTO> findClientsByIdentificationNumber(String id_num);

    public List<ClientDTO> findClientsByGender(String gender);

    public List<ClientDTO> findAll();

    public List<ClientDTO> findClientsByFirstName(String name);

    public List<ClientDTO> findClientsByFirstAndLastName(String name, String surname);

    public Page<ClientDTO> findAll(Pageable pageable);

}
