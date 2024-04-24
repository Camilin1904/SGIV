package co.edu.icesi.sgiv.mapper.modification;

import co.edu.icesi.sgiv.domain.modification.DestinationModification;
import co.edu.icesi.sgiv.dto.modification.DestinationModificationDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DestinationModificationMapper {
    public DestinationModificationDTO toDTO(DestinationModification destinationModification);
    public List<DestinationModificationDTO> toDTOs(List<DestinationModification> destinationModifications);
}
