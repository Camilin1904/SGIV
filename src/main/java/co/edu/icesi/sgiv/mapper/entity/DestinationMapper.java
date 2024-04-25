package co.edu.icesi.sgiv.mapper.entity;

import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.dto.entity.DestinationCreationDTO;
import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DestinationMapper {
    public DestinationDTO toDTO(Destination destination);
    public Destination toEntity(DestinationCreationDTO destinationCreationDTO);
    public List<DestinationDTO> toDTOs(List<Destination> destinations);
    public List<Destination> toEntitys(List<DestinationCreationDTO> destinationCreationDTOs);
}
