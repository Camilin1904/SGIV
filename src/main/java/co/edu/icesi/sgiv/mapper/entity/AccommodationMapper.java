package co.edu.icesi.sgiv.mapper.entity;

import co.edu.icesi.sgiv.domain.entity.Accommodation;
import co.edu.icesi.sgiv.dto.entity.AccommodationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccommodationMapper {

    AccommodationMapper INSTANCE = Mappers.getMapper(AccommodationMapper.class);

    @Mapping(target = "id", source = "id")
    public AccommodationDTO toDTO(Accommodation client);
    @Mapping(target = "id", source = "id")
    public Accommodation toEntity(AccommodationDTO accommodationDTO);
}
