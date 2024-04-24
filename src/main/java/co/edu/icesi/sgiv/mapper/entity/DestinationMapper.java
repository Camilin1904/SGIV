package co.edu.icesi.sgiv.mapper.entity;

import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.dto.entity.DestinationCreationDTO;
import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import co.edu.icesi.sgiv.repository.entity.UserRepository;
import co.edu.icesi.sgiv.repository.status.DestinationStatusRepository;
import co.edu.icesi.sgiv.repository.type.DestinationTypeRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;

@Mapper
public interface DestinationMapper {
    public DestinationDTO toDTO(Destination destination);
    public Destination toEntity(DestinationCreationDTO destinationCreationDTO);
    public List<DestinationDTO> toDTOs(List<Destination> destinations);
    public List<Destination> toEntitys(List<DestinationCreationDTO> destinationCreationDTOs);
}
