package co.edu.icesi.sgiv.mapper.entity;

import co.edu.icesi.sgiv.domain.entity.Meals;
import co.edu.icesi.sgiv.domain.entity.Transportation;
import co.edu.icesi.sgiv.dto.entity.MealsDTO;
import co.edu.icesi.sgiv.dto.entity.TransportationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransportationMapper {

    TransportationMapper INSTANCE = Mappers.getMapper(TransportationMapper.class);

    @Mapping(target = "id", source = "id")
    public TransportationDTO toDTO(Transportation transportation);

    @Mapping(target = "id", source = "id")
    public Transportation toEntity(TransportationDTO transportationDTO);

}
