package co.edu.icesi.sgiv.service.implementation.entity;

import co.edu.icesi.sgiv.domain.entity.Transportation;
import co.edu.icesi.sgiv.dto.entity.TransportationDTO;
import co.edu.icesi.sgiv.mapper.entity.TransportationMapper;
import co.edu.icesi.sgiv.repository.entity.TransportationRepository;
import co.edu.icesi.sgiv.service.abstraction.entity.TransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransportationServiceImplementation implements TransportationService {

    @Autowired
    private TransportationRepository transportationRepository;

    private final TransportationMapper transportationMapper = TransportationMapper.INSTANCE;

    @Override
    public Page<TransportationDTO> findAll(Pageable page) {
        Page<Transportation> transportation = transportationRepository.findAll(page);
        return transportation.map(transportationMapper::toDTO);
    }

    @Override
    public List<TransportationDTO> findAll() {
        List<Transportation> transportation = transportationRepository.findAll();
        return transportation.stream().map(transportationMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<TransportationDTO> findByID(Long aLong) {
        Optional<Transportation> transportation = transportationRepository.findById(aLong);
        return transportation.map(transportationMapper::toDTO);
    }

    @Override
    public TransportationDTO save(TransportationDTO entity) throws Exception {
        if(!transportationRepository.existsById(entity.getId()))
            return transportationMapper.toDTO(transportationRepository.findById(entity.getId()).get());
        else
            throw new Exception("The transportation already exists");
    }

    @Override
    public TransportationDTO update(TransportationDTO entity) throws Exception {
        if(transportationRepository.existsById(entity.getId()))
            return transportationMapper.toDTO(transportationRepository.findById(entity.getId()).get());
        else
            throw new Exception("The transportation does not exists");
    }

    @Override
    public void delete(TransportationDTO entity) throws Exception {
        if(transportationRepository.existsById(entity.getId()))
            transportationRepository.delete(transportationRepository.findById(entity.getId()).get());
        else
            throw new Exception("The transportation does not exists");
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        if(transportationRepository.existsById(aLong))
            transportationRepository.deleteById(aLong);
        else
            throw new Exception("The transportation does not exists");
    }

    @Override
    public void validate(TransportationDTO entity) throws Exception {

    }

    @Override
    public long count() {
        return transportationRepository.count();
    }
}
