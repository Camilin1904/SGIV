package co.edu.icesi.sgiv.service.implementation.resources;

import co.edu.icesi.sgiv.domain.resources.DestinationImage;
import co.edu.icesi.sgiv.domain.type.DestinationType;
import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import co.edu.icesi.sgiv.dto.resources.DestinationImageDTO;
import co.edu.icesi.sgiv.dto.status.DestinationStatusDTO;
import co.edu.icesi.sgiv.repository.entity.DestinationRepository;
import co.edu.icesi.sgiv.repository.resources.DestinationImageRepository;
import co.edu.icesi.sgiv.service.abstraction.entity.DestinationService;
import co.edu.icesi.sgiv.service.abstraction.resources.DestinationImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationImageServiceImplementation implements DestinationImageService{

    @Autowired
    private DestinationImageRepository destinationImageRepository;

    @Override
    public List<DestinationImageDTO> findByDestinationId(Long id) {
        return List.of();
    }

    @Override
    public List<DestinationImage> findAll() {
        return List.of();
    }

    @Override
    public Optional<DestinationImage> findByID(Long aLong) {
        return Optional.empty();
    }

    @Override
    public DestinationImage save(DestinationImage entity) throws Exception {
        return null;
    }

    @Override
    public DestinationImage update(DestinationImage entity) throws Exception {
        return null;
    }

    @Override
    public void delete(DestinationImage entity) throws Exception {

    }

    @Override
    public void deleteById(Long aLong) throws Exception {

    }

    @Override
    public void validate(DestinationImage entity) throws Exception {

    }

    @Override
    public long count() {
        return 0;
    }
}
