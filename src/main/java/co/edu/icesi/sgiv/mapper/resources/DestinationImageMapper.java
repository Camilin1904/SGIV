package co.edu.icesi.sgiv.mapper.resources;

import co.edu.icesi.sgiv.domain.resources.DestinationImage;
import co.edu.icesi.sgiv.dto.resources.DestinationImageDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DestinationImageMapper {
    DestinationImageMapper INSTANCE = Mappers.getMapper(DestinationImageMapper.class);

    @Mapping(target = "id", source = "id")
    DestinationImageDTO toDTO(DestinationImage destinationImage);
    @Mapping(target = "id", source = "id")
    DestinationImage toEntity(DestinationImageDTO destinationImage);

    @Mapping(target = "id", source = "id")
    List<DestinationImageDTO> toDTO(List<DestinationImage> destinationImages);
}
