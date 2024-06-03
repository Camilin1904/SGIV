package co.edu.icesi.sgiv.service.implementation.type;

import co.edu.icesi.sgiv.dto.type.UserTypeDTO;
import co.edu.icesi.sgiv.mapper.type.UserTypeMapper;
import co.edu.icesi.sgiv.repository.type.UserTypeRepository;
import co.edu.icesi.sgiv.service.abstraction.type.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserTypeServiceImplementation implements UserTypeService {

    @Autowired
    private UserTypeRepository userTypeRepository;

    private final UserTypeMapper userTypeMapper = UserTypeMapper.INSTANCE;


    @Override
    public List<UserTypeDTO> findAll() {
        return userTypeRepository.findAll().stream().map(userTypeMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<UserTypeDTO> findByID(Long aLong) {
        return userTypeRepository.findById(aLong).map(userTypeMapper::toDTO);
    }

    @Override
    public UserTypeDTO save(UserTypeDTO entity) throws Exception {
        return null;
    }

    @Override
    public UserTypeDTO update(UserTypeDTO entity) throws Exception {
        return null;
    }

    @Override
    public void delete(UserTypeDTO entity) throws Exception {

    }

    @Override
    public void deleteById(Long aLong) throws Exception {
            userTypeRepository.deleteById(aLong);
    }

    @Override
    public void validate(UserTypeDTO entity) throws Exception {

    }

    @Override
    public long count() {
        return userTypeRepository.count();
    }
}
