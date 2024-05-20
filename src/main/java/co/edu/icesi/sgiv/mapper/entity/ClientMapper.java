package co.edu.icesi.sgiv.mapper.entity;

import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.dto.entity.ClientDTO;
import co.edu.icesi.sgiv.mapper.type.IdentificationTypeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(uses = {PlanMapper.class, UserMapper.class, IdentificationTypeMapper.class})
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(target = "id", source = "id")
    public ClientDTO toDTO(Client client);
    @Mapping(target = "id", source = "id")
    public Client toEntity(ClientDTO creationDTO);

}
