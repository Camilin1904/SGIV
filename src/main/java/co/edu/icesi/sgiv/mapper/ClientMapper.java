package co.edu.icesi.sgiv.mapper;

import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.domain.entity.Plan;
import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.dto.entity.ClientCreationDTO;
import co.edu.icesi.sgiv.dto.entity.ClientDTO;
import co.edu.icesi.sgiv.repository.entity.UserRepository;
import co.edu.icesi.sgiv.repository.status.ClientStatusRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public class ClientMapper {
    public ClientDTO toDTO(Client client){
        String name = client.getFirstName() + " " + client.getLastName() + " " + client.getSecondLastName();
        String idNumber = client.getIdentificationNumber();
        String phone1 = client.getPhone1();
        String phone2 = client.getPhone2();
        String email = client.getEmail();
        Date birthDate = client.getBirthDate();
        String status = client.getStatus().getName();
        List<String> requestedPlans = client.getRequestedPlans().stream().map(Plan::getName).collect(Collectors.toList());
        return new ClientDTO(idNumber, name,phone1,phone2,email,birthDate,status,requestedPlans);
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    ClientStatusRepository clientStatusRepository;

    public Client toDomain(ClientCreationDTO clientCreationDTO){
        String idNumber = clientCreationDTO.getIdNumber();
        String name = clientCreationDTO.getName();
        String firstLastName  = clientCreationDTO.getFirstLastName();
        String secondLastName = clientCreationDTO.getSecondLastName();
        String phone1 = clientCreationDTO.getPhone1();
        String phone2 = clientCreationDTO.getPhone2();
        String email = clientCreationDTO.getEmail();
        String gender = clientCreationDTO.getGender();
        Date birthDate = clientCreationDTO.getBirthDate();
        User creator = userRepository.findById(Long.parseLong(clientCreationDTO.getCreator())).get();

        return new Client(idNumber, name, firstLastName,secondLastName,phone1,phone2,email, gender, birthDate, Date.valueOf(LocalDate.now()), creator, clientStatusRepository.findByName("Active").get());
    }
}
