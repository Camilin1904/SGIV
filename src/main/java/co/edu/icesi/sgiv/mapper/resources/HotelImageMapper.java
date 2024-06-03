package co.edu.icesi.sgiv.mapper.resources;

import co.edu.icesi.sgiv.domain.resources.HotelImage;
import co.edu.icesi.sgiv.dto.resources.HotelImageDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HotelImageMapper {

    HotelImageMapper INSTANCE = Mappers.getMapper(HotelImageMapper.class);

    @Mapping(target = "id", source = "id")
    HotelImageDTO toDTO(HotelImage destinationImage);
    @Mapping(target = "id", source = "id")
    HotelImage toEntity(HotelImageDTO destinationImage);

    @Mapping(target = "id", source = "id")
    List<HotelImageDTO> toDTO(List<HotelImage> destinationImages);
}
