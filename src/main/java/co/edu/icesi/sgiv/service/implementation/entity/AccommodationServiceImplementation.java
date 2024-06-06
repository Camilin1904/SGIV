package co.edu.icesi.sgiv.service.implementation.entity;

import co.edu.icesi.sgiv.domain.entity.Accommodation;
import co.edu.icesi.sgiv.dto.entity.AccommodationDTO;
import co.edu.icesi.sgiv.mapper.entity.AccommodationMapper;
import co.edu.icesi.sgiv.repository.entity.AccommodationRepository;
import co.edu.icesi.sgiv.service.abstraction.entity.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccommodationServiceImplementation implements AccommodationService {

    @Autowired
    private AccommodationRepository accommodationRepository;

    private final AccommodationMapper accommodationMapper = AccommodationMapper.INSTANCE;

    @Override
    public Page<AccommodationDTO> findAll(Pageable page) {
        Page<Accommodation> accommodation = accommodationRepository.findAll(page);
        return accommodation.map(accommodationMapper::toDTO);
    }

    @Override
    public List<AccommodationDTO> findAll() {
        List<Accommodation> accommodation = accommodationRepository.findAll();
        return accommodation.stream().map(accommodationMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<AccommodationDTO> findByID(Long aLong) {
        Optional<Accommodation> accommodation = accommodationRepository.findById(aLong);
        return accommodation.map(accommodationMapper::toDTO);
    }

    @Override
    public AccommodationDTO save(AccommodationDTO entity) throws Exception {
            return accommodationMapper.toDTO(accommodationRepository.save(accommodationMapper.toEntity(entity)));
    }

    @Override
    public AccommodationDTO update(AccommodationDTO entity) throws Exception {
        if(accommodationRepository.existsById(entity.getId()))
            return accommodationMapper.toDTO(accommodationRepository.save(accommodationMapper.toEntity(entity)));
        else
            throw new Exception("The accommodation does not exists");
    }

    @Override
    public void delete(AccommodationDTO entity) throws Exception {
        if(accommodationRepository.existsById(entity.getId()))
            accommodationRepository.delete(accommodationMapper.toEntity(entity));
        else
            throw new Exception("The accommodation does not exists");
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        if(accommodationRepository.existsById(aLong))
            accommodationRepository.deleteById(aLong);
        else
            throw new Exception("The accommodation does not exists");
    }

    @Override
    public void validate(AccommodationDTO entity) throws Exception {

    }

    @Override
    public long count() {
        return accommodationRepository.count();
    }
}
