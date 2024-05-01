package co.edu.icesi.sgiv.service.implementation.entity;


import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.domain.status.ClientStatus;
import co.edu.icesi.sgiv.dto.entity.ClientDTO;
import co.edu.icesi.sgiv.dto.status.ClientStatusDTO;
import co.edu.icesi.sgiv.mapper.entity.ClientMapper;
import co.edu.icesi.sgiv.mapper.status.ClientStatusMapper;
import co.edu.icesi.sgiv.repository.entity.ClientRepository;
import co.edu.icesi.sgiv.service.abstraction.entity.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ClientServiceImplementation implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    private final ClientMapper clientMapper = ClientMapper.INSTANCE;

    private final ClientStatusMapper clientStatusMapper = ClientStatusMapper.INSTANCE;

    @Override
    public Optional<ClientDTO> findByID(Long aLong) {
        Optional<Client> client = clientRepository.findById(aLong);
        if(client.isPresent())
            return Optional.of(clientMapper.toDTO(client.get()));
        else
            return Optional.empty();
    }

    @Override
    public ClientDTO save(ClientDTO entity) throws Exception {
        if (clientRepository.findById(entity.getId()).isPresent())
            throw new Exception("The entity already exists.");
        else{
            Client client = clientMapper.toEntity(entity);
            return clientMapper.toDTO(clientRepository.save(client));
        }

    }

    @Override
    public ClientDTO update(ClientDTO entity) throws Exception {
        if (clientRepository.findById(entity.getId()).isEmpty())
            throw new Exception("The entity does not exist.");
        else{
            Client client = clientMapper.toEntity(entity);
            return clientMapper.toDTO(clientRepository.save(client));
        }
    }

    @Override
    public void delete(ClientDTO entity) throws Exception {
        if (clientRepository.findById(entity.getId()).isEmpty())
            throw new Exception("The entity does not exist.");
        else{
            Client client = clientMapper.toEntity(entity);
            clientRepository.delete(client);
        }
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        clientRepository.delete(clientRepository.findById(aLong).get());
    }

    @Override
    public void validate(ClientDTO entity) throws Exception {

    }

    @Override
    public long count() {
        return clientRepository.count();
    }

    @Override
    public List<ClientDTO> findClientsByIdentificationNumber(String id_num) {
        List<Client> lClient = clientRepository.findClientsByIdentificationNumber(id_num);

        return lClient.stream().map(clientMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ClientDTO> findClientsByGender(String gender) {
        List<Client> lClient = clientRepository.findClientsByGender(gender);

        return lClient.stream().map(clientMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ClientDTO> findAll() {
        List<Client> lClient = clientRepository.findAll();

        return lClient.stream().map(clientMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ClientDTO> findClientsByFirstName(String name) {
        List<Client> lClient = clientRepository.findClientsByFirstName(name);

        return lClient.stream().map(clientMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ClientDTO> findClientsByFirstAndLastName(String name, String surname) {
        List<Client> lClient = clientRepository.findClientsByFirstAndLastName(name, surname);

        return lClient.stream().map(clientMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<ClientStatusDTO> getStatus(Long cID) {
        Optional<ClientStatus> clientStatus = clientRepository.getStatus(cID);
        if (clientStatus.isEmpty())
            return Optional.empty();
        else
            return Optional.of(clientStatusMapper.toDTO(clientStatus.get()));
    }
}
