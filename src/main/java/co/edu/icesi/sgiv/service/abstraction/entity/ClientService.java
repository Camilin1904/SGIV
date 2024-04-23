package co.edu.icesi.sgiv.service.abstraction.entity;

import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.domain.entity.Plan;
import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.domain.modification.ClientModification;
import co.edu.icesi.sgiv.domain.status.ClientStatus;
import co.edu.icesi.sgiv.domain.type.IdentificationType;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface ClientService extends GenericService<Client, Long> {


    public List<Client> findClientsByIdentificationNumber(String id_num);

    public List<Client> findClientsByGender(String gender);

    public List<Client> findAll();

    public List<Client> findClientsByFirstName(String name);

    public List<Client> findClientsByFirstAndLastName(String name, String surname);

    public Optional<ClientStatus> getStatus(Long cID);
}
