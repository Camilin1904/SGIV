package co.edu.icesi.sgiv.mapper;

import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.dto.entity.DestinationCreationDTO;
import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import co.edu.icesi.sgiv.repository.entity.UserRepository;
import co.edu.icesi.sgiv.repository.status.DestinationStatusRepository;
import co.edu.icesi.sgiv.repository.type.DestinationTypeRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

@Mapper
public class DestinationMapper {

    public DestinationDTO toDTO(Destination destination){
        String code = destination.getCode();

        String name = destination.getName();

        Date creationDate = destination.getCreationDate();

        String status = destination.getStatus().getName();

        String type = destination.getType().getName();

        return new DestinationDTO(code, name, creationDate, status, type);
    }


    @Autowired
    UserRepository userRepository;

    @Autowired
    DestinationStatusRepository destinationStatusRepository;

    @Autowired
    DestinationTypeRepository destinationTypeRepository;

    public Destination toDomain(DestinationCreationDTO destinationCreationDTO){
        String code = destinationCreationDTO.getCode();

        String name = destinationCreationDTO.getName();

        Date creationDate = destinationCreationDTO.getCreationDate();

        String creator = destinationCreationDTO.getCreator();

        String status = destinationCreationDTO.getStatus();

        String type = destinationCreationDTO.getType();

        return new Destination(code,name,creationDate,userRepository.findById(Long.parseLong(creator)).get(), destinationStatusRepository.findByName(status).get(), destinationTypeRepository.findById(Long.parseLong(type)).get());
    }
}
