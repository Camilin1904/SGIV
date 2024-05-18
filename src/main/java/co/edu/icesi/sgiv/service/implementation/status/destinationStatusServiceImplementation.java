package co.edu.icesi.sgiv.service.implementation.status;

import co.edu.icesi.sgiv.domain.status.DestinationStatus;
import co.edu.icesi.sgiv.dto.status.DestinationStatusDTO;
import co.edu.icesi.sgiv.mapper.status.DestinationStatusMapper;
import co.edu.icesi.sgiv.repository.status.DestinationStatusRepository;
import co.edu.icesi.sgiv.service.abstraction.status.DestinationStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class destinationStatusServiceImplementation implements DestinationStatusService {

    @Autowired
    private DestinationStatusRepository destinationStatusRepository;

    private final DestinationStatusMapper destinationStatusMapper = DestinationStatusMapper.INSTANCE;

    @Override
    public List<DestinationStatusDTO> findAll() {
        List<DestinationStatus> destinationStatuses =  destinationStatusRepository.findAll();
        return destinationStatuses.stream().map(destinationStatusMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<DestinationStatusDTO> findByID(Long aLong) {
        return destinationStatusRepository.findById(aLong).map(destinationStatusMapper::toDTO);
    }

    @Override
    public DestinationStatusDTO save(DestinationStatusDTO entity) throws Exception {
        if(destinationStatusRepository.existsById(entity.getId()))
            return destinationStatusMapper.toDTO(destinationStatusRepository.save(destinationStatusMapper.toEntity(entity)));
        else {
            throw new Exception("The entity already exists");
        }
    }

    @Override
    public DestinationStatusDTO update(DestinationStatusDTO entity) throws Exception {
        if(!destinationStatusRepository.existsById(entity.getId()))
            return destinationStatusMapper.toDTO(destinationStatusRepository.save(destinationStatusMapper.toEntity(entity)));
        else {
            throw new Exception("The entity does not exist");
        }
    }

    @Override
    public void delete(DestinationStatusDTO entity) throws Exception {
        if(!destinationStatusRepository.existsById(entity.getId()))
            destinationStatusRepository.delete(destinationStatusMapper.toEntity(entity));
        else {
            throw new Exception("The entity does not exist");
        }
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        if(!destinationStatusRepository.existsById(aLong))
            destinationStatusRepository.deleteById(aLong);
        else {
            throw new Exception("The entity does not exist");
        }
    }

    @Override
    public void validate(DestinationStatusDTO entity) throws Exception {

    }

    @Override
    public long count() {
        return destinationStatusRepository.count();
    }
}
