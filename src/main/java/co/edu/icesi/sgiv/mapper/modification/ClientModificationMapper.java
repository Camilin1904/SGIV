package co.edu.icesi.sgiv.mapper.modification;

import co.edu.icesi.sgiv.domain.modification.ClientModification;
import co.edu.icesi.sgiv.dto.modification.ClientModificationDTO;
import co.edu.icesi.sgiv.mapper.entity.ClientMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = ClientMapper.class)
public interface ClientModificationMapper {

    ClientModificationMapper INSTANCE = Mappers.getMapper(ClientModificationMapper.class);
    @Mapping(target = "id", source = "id")
    public ClientModificationDTO toDTO(ClientModification clientModification);
    @Mapping(target = "id", source = "id")
    public List<ClientModificationDTO> toDTOs(List<ClientModification> clientModifications);
    
}
