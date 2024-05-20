package co.edu.icesi.sgiv.mapper.entity;
import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.domain.type.DestinationType;
import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class TestDestinationMapper {

    private final DestinationMapper destinationMapper = DestinationMapper.INSTANCE;
/*
    @Test
    public void shouldNotHaveNullAttributes() {
        // Create a Destination object
        User user = new User(); // You may need to initialize User properly
        DestinationType type = new DestinationType(); // You may need to initialize DestinationType properly
        Destination destination = new Destination("ABC123", "Test Destination", new Date(System.currentTimeMillis()), user, "Active", type);
        destination.setId(1L);

        // Get DestinationDTO using a mapper, assuming you have one
        DestinationDTO destinationDTO = destinationMapper.toDTO(destination);

        // Assertions
        assertNotNull(destinationDTO.getId());
        assertNotNull(destinationDTO.getCode());
        assertNotNull(destinationDTO.getName());
        assertNotNull(destinationDTO.getCreationDate());
        assertNotNull(destinationDTO.getUser());
        assertNotNull(destinationDTO.getStatus());
        assertNotNull(destinationDTO.getType());
    }*/
}