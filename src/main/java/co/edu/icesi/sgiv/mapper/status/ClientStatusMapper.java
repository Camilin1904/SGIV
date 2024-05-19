package co.edu.icesi.sgiv.mapper.status;

import co.edu.icesi.sgiv.dto.status.ClientStatusDTO;
import co.edu.icesi.sgiv.mapper.entity.ClientMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = ClientMapper.class)
public interface ClientStatusMapper {

    ClientStatusMapper INSTANCE = Mappers.getMapper(ClientStatusMapper.class);

    @Mapping(target = "id", source = "id")
    public ClientStatusDTO toDTO(ClientStatus clientStatus);
    @Mapping(target = "id", source = "id")
    public List<ClientStatusDTO> toDTOs(List<ClientStatus> clientStatuses);
}
