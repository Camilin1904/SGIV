package co.edu.icesi.sgiv.service.implementation.type;

import co.edu.icesi.sgiv.domain.type.DestinationType;
import co.edu.icesi.sgiv.dto.type.DestinationTypeDTO;
import co.edu.icesi.sgiv.mapper.type.DestinationTypeMapper;
import co.edu.icesi.sgiv.repository.type.DestinationTypeRepository;
import co.edu.icesi.sgiv.service.abstraction.type.DestinationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DestnationTypeServiceImplementation implements DestinationTypeService {

    @Autowired
    private DestinationTypeRepository destinationTypeRepository;

    private final DestinationTypeMapper destinationTypeMapper = DestinationTypeMapper.INSTANCE;


    @Override
    public List<DestinationTypeDTO> findAll() {
        List<DestinationType> destinationTypes = destinationTypeRepository.findAll();
        return destinationTypes.stream().map(destinationTypeMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<DestinationTypeDTO> findByID(Long aLong) {
       Optional<DestinationType> destinationType = destinationTypeRepository.findById(aLong);
       return destinationType.map(destinationTypeMapper::toDTO);
    }

    @Override
    public DestinationTypeDTO save(DestinationTypeDTO entity) throws Exception {
        if(destinationTypeRepository.existsById(entity.getId()))
            return destinationTypeMapper.toDTO(destinationTypeRepository.save(destinationTypeMapper.toEntity(entity)));
        else {
            throw new Exception("Destination type already exists");
        }
    }

    @Override
    public DestinationTypeDTO update(DestinationTypeDTO entity) throws Exception {
        if(!destinationTypeRepository.existsById(entity.getId()))
            return destinationTypeMapper.toDTO(destinationTypeRepository.save(destinationTypeMapper.toEntity(entity)));
        else {
            throw new Exception("Destination type does not exist");
        }
    }

    @Override
    public void delete(DestinationTypeDTO entity) throws Exception {
        if(!destinationTypeRepository.existsById(entity.getId()))
            destinationTypeRepository.delete(destinationTypeMapper.toEntity(entity));
        else {
            throw new Exception("Destination type does not exist");
        }
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        if(!destinationTypeRepository.existsById(aLong))
            destinationTypeRepository.deleteById(aLong);
        else {
            throw new Exception("Destination type does not exist");
        }
    }

    @Override
    public void validate(DestinationTypeDTO entity) throws Exception {

    }

    @Override
    public long count() {
        return destinationTypeRepository.count();
    }


}
