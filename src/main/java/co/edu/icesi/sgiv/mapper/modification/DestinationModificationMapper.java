package co.edu.icesi.sgiv.mapper.modification;

import co.edu.icesi.sgiv.domain.modification.DestinationModification;
import co.edu.icesi.sgiv.dto.modification.DestinationModificationDTO;
import co.edu.icesi.sgiv.mapper.entity.DestinationMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = DestinationMapper.class)
public interface DestinationModificationMapper {

    DestinationModificationMapper INSTANCE = Mappers.getMapper(DestinationModificationMapper.class);
    @Mapping(target = "id", source = "id")
    public DestinationModificationDTO toDTO(DestinationModification destinationModification);
    @Mapping(target = "id", source = "id")
    public List<DestinationModificationDTO> toDTOs(List<DestinationModification> destinationModifications);
}
