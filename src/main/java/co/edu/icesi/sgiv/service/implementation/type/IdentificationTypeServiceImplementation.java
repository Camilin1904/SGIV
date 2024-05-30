package co.edu.icesi.sgiv.service.implementation.type;

import co.edu.icesi.sgiv.domain.type.IdentificationType;
import co.edu.icesi.sgiv.dto.type.IdentificationTypeDTO;
import co.edu.icesi.sgiv.mapper.type.IdentificationTypeMapper;
import co.edu.icesi.sgiv.repository.type.IdentificationTypeRepository;
import co.edu.icesi.sgiv.service.abstraction.type.IdentificationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IdentificationTypeServiceImplementation implements IdentificationTypeService {
    @Autowired
    private IdentificationTypeRepository identificationTypeRepository;

    private final IdentificationTypeMapper identificationTypeMapper = IdentificationTypeMapper.INSTANCE;


    @Override
    public List<IdentificationTypeDTO> findAll() {
        List<IdentificationType> identificationTypes = identificationTypeRepository.findAll();
        return identificationTypes.stream().map(identificationTypeMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<IdentificationTypeDTO> findByID(Long aLong) {
        Optional<IdentificationType> identificationType = identificationTypeRepository.findById(aLong);
        return identificationType.map(identificationTypeMapper::toDTO);
    }

    @Override
    public IdentificationTypeDTO save(IdentificationTypeDTO entity) throws Exception {
        if(identificationTypeRepository.existsById(entity.getId()))
            return identificationTypeMapper.toDTO(identificationTypeRepository.save(identificationTypeMapper.toEntity(entity)));
        else {
            throw new Exception("Identification type already exists");
        }
    }

    @Override
    public IdentificationTypeDTO update(IdentificationTypeDTO entity) throws Exception {
        if(!identificationTypeRepository.existsById(entity.getId()))
            return identificationTypeMapper.toDTO(identificationTypeRepository.save(identificationTypeMapper.toEntity(entity)));
        else {
            throw new Exception("Identification type does not exist");
        }
    }

    @Override
    public void delete(IdentificationTypeDTO entity) throws Exception {
        if(!identificationTypeRepository.existsById(entity.getId()))
            identificationTypeRepository.delete(identificationTypeMapper.toEntity(entity));
        else {
            throw new Exception("Identification type does not exist");
        }
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        if(!identificationTypeRepository.existsById(aLong))
            identificationTypeRepository.deleteById(aLong);
        else {
            throw new Exception("Identification type does not exist");
        }
    }

    @Override
    public void validate(IdentificationTypeDTO entity) throws Exception {

    }

    @Override
    public long count() {
        return identificationTypeRepository.count();
    }

}
