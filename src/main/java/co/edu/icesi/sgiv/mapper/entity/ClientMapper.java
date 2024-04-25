package co.edu.icesi.sgiv.mapper.entity;

import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.dto.entity.ClientCreationDTO;
import co.edu.icesi.sgiv.dto.entity.ClientDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ClientMapper {

    public ClientDTO toDTO(Client client);
    public List<ClientDTO> toDTOs(List<Client> clients);
    public Client toEntity(ClientCreationDTO creationDTO);
    public List<Client> toEntitys(List<ClientCreationDTO> creationDTOs);

}
