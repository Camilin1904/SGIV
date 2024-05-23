package co.edu.icesi.sgiv.service.implementation.resources;

import co.edu.icesi.sgiv.domain.resources.DestinationImage;
import co.edu.icesi.sgiv.dto.resources.DestinationImageDTO;
import co.edu.icesi.sgiv.mapper.resources.DestinationImageMapper;
import co.edu.icesi.sgiv.repository.resources.DestinationImageRepository;
import co.edu.icesi.sgiv.service.abstraction.resources.DestinationImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationImageServiceImplementation implements DestinationImageService{

    @Autowired
    private DestinationImageRepository destinationImageRepository;

    private DestinationImageMapper destinationImageMapper = DestinationImageMapper.INSTANCE;

    @Override
    public List<DestinationImageDTO> findByDestinationId(Long id) {
        return destinationImageMapper.toDTO(destinationImageRepository.findByDestinationId(id));
    }

    @Override
    public List<DestinationImage> findAll() {
        return destinationImageRepository.findAll();
    }

    @Override
    public Optional<DestinationImage> findByID(Long aLong) {
        return destinationImageRepository.findById(aLong);
    }

    @Override
    public DestinationImage save(DestinationImage entity) throws Exception {
        return destinationImageRepository.save(entity);
    }

    @Override
    public DestinationImage update(DestinationImage entity) throws Exception {
        return destinationImageRepository.save(entity);
    }

    @Override
    public void delete(DestinationImage entity) throws Exception {
        destinationImageRepository.delete(entity);
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        destinationImageRepository.deleteById(aLong);
    }

    @Override
    public void validate(DestinationImage entity) throws Exception {

    }

    @Override
    public long count() {
        return destinationImageRepository.count();
    }
}
