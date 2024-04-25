package co.edu.icesi.sgiv.mapper.status;

import co.edu.icesi.sgiv.domain.status.ClientStatus;
import co.edu.icesi.sgiv.dto.status.ClientStatusDTO;
import co.edu.icesi.sgiv.mapper.entity.ClientMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = ClientMapper.class)
public interface ClientStatusMapper {

    ClientStatusMapper INSTANCE = Mappers.getMapper(ClientStatusMapper.class);

    public ClientStatusDTO toDTO(ClientStatus clientStatus);
    public List<ClientStatusDTO> toDTOs(List<ClientStatus> clientStatuses);
}
