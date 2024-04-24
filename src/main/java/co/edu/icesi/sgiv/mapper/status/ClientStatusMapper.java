package co.edu.icesi.sgiv.mapper.status;

import co.edu.icesi.sgiv.domain.status.ClientStatus;
import co.edu.icesi.sgiv.dto.status.ClientStatusDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ClientStatusMapper {
    public ClientStatusDTO toDTO(ClientStatus clientStatus);
    public List<ClientStatusDTO> toDTOs(List<ClientStatus> clientStatuses);
}
