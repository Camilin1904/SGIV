package co.edu.icesi.sgiv.service.implementation.entity;

import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.status.DestinationStatus;
import co.edu.icesi.sgiv.domain.type.DestinationType;
import co.edu.icesi.sgiv.repository.entity.DestinationRepository;
import co.edu.icesi.sgiv.service.abstraction.entity.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DestinationServiceImplementation implements DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    @Override
    public Optional<Destination> findByID(Long aLong) {

        return destinationRepository.findById(aLong);
    }

    @Override
    public Destination save(Destination entity) throws Exception {
        return destinationRepository.save(entity);
    }

    @Override
    public Destination update(Destination entity) throws Exception {
        if(findByID(entity.getId()).isPresent())
            throw new Exception("Element already exists.");
        return destinationRepository.save(entity);
    }

    @Override
    public void delete(Destination entity) throws Exception {

    }

    @Override
    public void deleteById(Long aLong) throws Exception {

    }

    @Override
    public void validate(Destination entity) throws Exception {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public List<Destination> findAll() {
        return null;
    }

    @Override
    public List<Destination> findDestinationsByDestinationTypeName(String dType) {
        return null;
    }

    @Override
    public List<Destination> findDestinationsByCode(String code) {
        return null;
    }

    @Override
    public Optional<DestinationStatus> getStatus(Long DID) {
        return Optional.empty();
    }

    @Override
    public List<Destination> findDestinationsByDestinationType(DestinationType dt) {
        return null;
    }
}
