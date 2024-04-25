package co.edu.icesi.sgiv.service.implementation.entity;

import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.status.DestinationStatus;
import co.edu.icesi.sgiv.domain.type.DestinationType;
import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import co.edu.icesi.sgiv.dto.status.DestinationStatusDTO;
import co.edu.icesi.sgiv.mapper.entity.DestinationMapper;
import co.edu.icesi.sgiv.mapper.status.DestinationStatusMapper;
import co.edu.icesi.sgiv.repository.entity.DestinationRepository;
import co.edu.icesi.sgiv.service.abstraction.entity.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DestinationServiceImplementation implements DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private DestinationMapper destinationMapper;

    @Autowired
    private DestinationStatusMapper destinationStatusMapper;

    @Override
    public Optional<DestinationDTO> findByID(Long aLong) {
        Optional<Destination> destination = destinationRepository.findById(aLong);
        if(destination.isPresent())
            return Optional.of(destinationMapper.toDTO(destination.get()));
        else
            return Optional.empty();
    }

    @Override
    public DestinationDTO save(DestinationDTO entity) throws Exception {
        if (destinationRepository.findById(entity.getId()).isPresent())
            throw new Exception("The entity already exists.");
        else{
            Destination destination = destinationMapper.toEntity(entity);
            return destinationMapper.toDTO(destinationRepository.save(destination));
        }

    }

    @Override
    public DestinationDTO update(DestinationDTO entity) throws Exception {
        if (destinationRepository.findById(entity.getId()).isEmpty())
            throw new Exception("The entity does not exist.");
        else{
            Destination destination = destinationMapper.toEntity(entity);
            return destinationMapper.toDTO(destinationRepository.save(destination));
        }
    }

    @Override
    public void delete(DestinationDTO entity) throws Exception {
        if (destinationRepository.findById(entity.getId()).isEmpty())
            throw new Exception("The entity does not exist.");
        else{
            Destination destination = destinationMapper.toEntity(entity);
            destinationRepository.delete(destination);
        }
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        destinationRepository.delete(destinationRepository.findById(aLong).get());
    }

    @Override
    public void validate(DestinationDTO entity) throws Exception {

    }

    @Override
    public long count() {
        return destinationRepository.count();
    }

    @Override
    public List<DestinationDTO> findAll() {
        List<Destination> dest = destinationRepository.findAll();
        return dest.stream().map(destinationMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<DestinationDTO> findDestinationsByDestinationTypeName(String dType) {
        List<Destination> dest = destinationRepository.findDestinationsByDestinationTypeName(dType);
        return dest.stream().map(destinationMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<DestinationDTO> findDestinationsByCode(String code) {
        List<Destination> dest = destinationRepository.findDestinationsByCode(code);
        return dest.stream().map(destinationMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<DestinationStatusDTO> getStatus(Long DID) {
        Optional<DestinationStatus> ds = destinationRepository.getStatus(DID);
        if (ds.isEmpty())
            return Optional.empty();
        else
            return Optional.of(destinationStatusMapper.toDTO(ds.get()));
    }

    @Override
    public List<DestinationDTO> findDestinationsByDestinationType(DestinationType dt) {
        List<Destination> dest = destinationRepository.findDestinationsByDestinationType(dt);
        return dest.stream().map(destinationMapper::toDTO).collect(Collectors.toList());    }
}
