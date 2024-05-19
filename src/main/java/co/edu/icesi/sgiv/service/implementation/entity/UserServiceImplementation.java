package co.edu.icesi.sgiv.service.implementation.entity;

import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.dto.entity.UserDTO;
import co.edu.icesi.sgiv.dto.status.UserStatusDTO;
import co.edu.icesi.sgiv.mapper.entity.UserMapper;
import co.edu.icesi.sgiv.mapper.status.UserStatusMapper;
import co.edu.icesi.sgiv.repository.entity.UserRepository;
import co.edu.icesi.sgiv.service.abstraction.entity.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserServiceImplementation implements UserService {


    UserMapper userMapper = UserMapper.INSTANCE;
    @Autowired
    UserRepository userRepository;

    UserStatusMapper userStatusMapper = UserStatusMapper.INSTANCE;
    
    @Override
    public Optional<UserDTO> findByID(Long aLong) {
        Optional<User> user = userRepository.findById(aLong);
        return user.map(value -> userMapper.toDTO(value));
    }

    @Override
    public UserDTO save(UserDTO entity) throws Exception {
        if (userRepository.findById(entity.getId()).isPresent())
            throw new Exception("The entity already exists.");
        else{
            User user = userMapper.toEntity(entity);
            return userMapper.toDTO(userRepository.save(user));
        }

    }

    @Override
    public UserDTO update(UserDTO entity) throws Exception {
        if (userRepository.findById(entity.getId()).isEmpty())
            throw new Exception("The entity does not exist.");
        else{
            User user = userMapper.toEntity(entity);
            return userMapper.toDTO(userRepository.save(user));
        }
    }

    @Override
    public void delete(UserDTO entity) throws Exception {
        if (userRepository.findById(entity.getId()).isEmpty())
            throw new Exception("The entity does not exist.");
        else{
            User user = userMapper.toEntity(entity);
            userRepository.delete(user);
        }
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        userRepository.delete(userRepository.findById(aLong).get());
    }

    @Override
    public void validate(UserDTO entity) throws Exception {

    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> dest = userRepository.findAll();
        return dest.stream().map(userMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findAllByType(Long type) {
        List<User> dest = userRepository.findAllByType(type);
        return dest.stream().map(userMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
