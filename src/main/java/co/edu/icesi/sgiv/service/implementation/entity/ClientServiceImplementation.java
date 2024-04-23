package co.edu.icesi.sgiv.service.implementation.entity;

import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.domain.status.ClientStatus;
import co.edu.icesi.sgiv.repository.entity.ClientRepository;
import co.edu.icesi.sgiv.service.abstraction.entity.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ClientServiceImplementation implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Optional<Client> findByID(Long aLong) {
        return clientRepository.findById(aLong);
    }

    @Override
    public Client save(Client entity) throws Exception {
        if(findByID((entity.getId())).isPresent())
            throw new Exception(("Element already exists."));

        return clientRepository.save(entity);
    }

    @Override
    public Client update(Client entity) throws Exception {
        if(findByID(entity.getId()).isEmpty())
            throw new Exception("Element does not exist.");
        return clientRepository.save((entity));
    }

    @Override
    public void delete(Client entity) throws Exception {
        if(findByID(entity.getId()).isEmpty())
            throw new Exception("Element does not exist.");
        clientRepository.delete(entity);
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        if(findByID(aLong).isEmpty())
            throw new Exception("Element does not exist.");
        clientRepository.delete(findByID(aLong).get());
    }

    @Override
    public void validate(Client entity) throws Exception {

    }

    @Override
    public long count() {
        return clientRepository.count();
    }

    @Override
    public List<Client> findClientsByIdentificationNumber(String id_num) {
        return clientRepository.findClientsByIdentificationNumber(id_num);
    }

    @Override
    public List<Client> findClientsByGender(String gender) {
        return clientRepository.findClientsByGender(gender);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> findClientsByFirstName(String name) {
        return clientRepository.findClientsByFirstName(name);
    }

    @Override
    public List<Client> findClientsByFirstAndLastName(String name, String surname) {
        return clientRepository.findClientsByFirstAndLastName(name, surname);
    }

    @Override
    public Optional<ClientStatus> getStatus(Long cID) {
        return clientRepository.getStatus(cID);
    }
}
