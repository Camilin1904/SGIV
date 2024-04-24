package co.edu.icesi.sgiv.mapper.status;

import co.edu.icesi.sgiv.domain.status.DestinationStatus;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DestinationStatusMapper {
    public DestinationStatus toDTO(DestinationStatus destinationStatus);
    public List<DestinationStatus> toDTOs(List<DestinationStatus> destinationStatuses);
}
