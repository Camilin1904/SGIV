package co.edu.icesi.sgiv.mapper.modification;

import co.edu.icesi.sgiv.domain.modification.ClientModification;
import co.edu.icesi.sgiv.dto.modification.ClientModificationDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ClientModificationMapper {
    
    public ClientModificationDTO toDTO(ClientModification clientModification);
    public List<ClientModificationDTO> toDTOs(List<ClientModification> clientModifications);
    
}
