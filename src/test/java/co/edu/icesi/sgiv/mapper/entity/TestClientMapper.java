package co.edu.icesi.sgiv.mapper.entity;


import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.domain.entity.Plan;
import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.domain.type.IdentificationType;
import co.edu.icesi.sgiv.dto.entity.ClientDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestClientMapper {

    private final ClientMapper clientMapper = ClientMapper.INSTANCE;


    @Test
    public void shouldNotHaveNullAttributes(){
        Client client = new Client();
        client.setFirstName("John");
        client.setLastName("Doe");
        client.setEmail("john@doe.com");
        client.setBirthDate(new Date(System.currentTimeMillis()));
        client.setId((long)123456789);
        client.setGender("Male");
        client.setIdentificationNumber("123456789");
        IdentificationType identificationType = new IdentificationType();
        client.setIdentificationType(identificationType);
        client.setPhone1("123456789");
        client.setPhone2("123456789");
        Plan plan = new Plan();
        plan.setClient(client);
        List<Plan> plans = new ArrayList<>();
        plans.add(plan);
        client.setRequestedPlans(plans);
        User user = new User();
        client.setUser(user);
        client.setSecondLastName("Doe");

        ClientDTO clientDTO = clientMapper.toDTO(client);

        System.out.println(clientDTO);

        assert clientDTO.getBirthDate() != null;
        assert clientDTO.getIdentificationNumber() != null;
        assert clientDTO.getPhone1() != null;
        assert clientDTO.getPhone2() != null;
        assert clientDTO.getGender() != null;
        assert clientDTO.getId() != null;
        assert clientDTO.getEmail() != null;
        assert clientDTO.getFirstName() != null;
        assert clientDTO.getLastName() != null;
        assert clientDTO.getIdentificationType() != null;
        assert clientDTO.getUser() != null;
        assert clientDTO.getSecondLastName() != null;
    }
}
