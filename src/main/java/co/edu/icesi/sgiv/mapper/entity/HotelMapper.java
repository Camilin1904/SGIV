package co.edu.icesi.sgiv.mapper.entity;

import co.edu.icesi.sgiv.domain.entity.Hotel;
import co.edu.icesi.sgiv.dto.entity.HotelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelMapper {

    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    @Mapping(target = "id", source = "id")
    public HotelDTO toDTO(Hotel hotel);
    @Mapping(target = "id", source = "id")
    public Hotel toEntity(HotelDTO hotelDTO);
}
