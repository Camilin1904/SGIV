package co.edu.icesi.sgiv.mapper.entity;

import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.domain.entity.Plan;
import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.dto.entity.ClientCreationDTO;
import co.edu.icesi.sgiv.dto.entity.ClientDTO;
import co.edu.icesi.sgiv.repository.entity.UserRepository;
import co.edu.icesi.sgiv.repository.status.ClientStatusRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface ClientMapper {

    public ClientDTO toDTO(Client client);
    public List<ClientDTO> toDTOs(List<Client> clients);
    public Client toEntity(ClientCreationDTO creationDTO);
    public List<Client> toEntitys(List<ClientCreationDTO> creationDTOs);

}
