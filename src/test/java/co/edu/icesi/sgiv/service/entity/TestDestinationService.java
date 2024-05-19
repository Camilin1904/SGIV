package co.edu.icesi.sgiv.service.entity;

import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import co.edu.icesi.sgiv.service.abstraction.entity.DestinationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestDestinationService {

    @Autowired
    private DestinationService destinationService;

    @Test
    public void shouldReturnAllDestinations(){
        long count = destinationService.count();

        Page<DestinationDTO> destinationDTOS = destinationService.findByFilter(null, null, null, null, PageRequest.of(0, (int)count));

        List<DestinationDTO> destinations = destinationDTOS.getContent();

        assertEquals(destinations.size(), count);
    }

    @Test
    public void shouldReturnDestinationsNamedCali(){
        long count = destinationService.count();
        Page<DestinationDTO> destinationDTOS = destinationService.findByFilter("Cali", null, null, null, PageRequest.of(0, (int)count));

        List<DestinationDTO> destinations = destinationDTOS.getContent();

        List<Boolean> allCali = destinations.stream().map((DestinationDTO d) -> {return d.getName().equals("Cali");}).toList();

        for (Boolean aCali : allCali) {
            assert aCali;
        }
    }
}
