package co.edu.icesi.sgiv.mapper.entity;

import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.dto.entity.ClientDTO;
import co.edu.icesi.sgiv.mapper.status.ClientStatusMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;


@Mapper(uses = {ClientStatusMapper.class, PlanMapper.class, UserMapper.class})
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
    @Mapping(target="name", source = ".", qualifiedByName = "getFullName")
    public ClientDTO toDTO(Client client);

    @Named("getFullName")
    default String getFullName(Client client){
        return client.getFirstName() + client.getLastName() + client.getSecondLastName();
    }

    public Client toEntity(ClientDTO creationDTO);

}
