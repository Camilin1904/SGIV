package co.edu.icesi.sgiv.mapper.entity;

import co.edu.icesi.sgiv.domain.entity.Meals;
import co.edu.icesi.sgiv.dto.entity.MealsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransportationMapper {

    TransportationMapper INSTANCE = Mappers.getMapper(TransportationMapper.class);

    @Mapping(target = "id", source = "id")
    public Meals toEntity(MealsDTO mealsDTO);

    @Mapping(target = "id", source = "id")
    public MealsDTO toDto(Meals meals);
}
