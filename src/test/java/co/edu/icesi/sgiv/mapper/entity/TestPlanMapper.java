package co.edu.icesi.sgiv.mapper.entity;
import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.domain.entity.Plan;
import co.edu.icesi.sgiv.domain.entity.PlanDetail;
import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.dto.entity.PlanDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class TestPlanMapper{

    private final PlanMapper planMapper = PlanMapper.INSTANCE;

    @Test
    public void shouldNotHaveNullAttributes() {
        // Create a Plan object
        Plan plan = new Plan();
        plan.setId(1L);
        plan.setCode("ABC123");
        plan.setNumberOfPeople(5);
        Date currentDate = new Date(System.currentTimeMillis());
        plan.setStartDate(currentDate);
        plan.setEndDate(currentDate);
        plan.setTotalValue(100.0);
        plan.setCreationDate(currentDate);
        User user = new User(); // You may need to initialize User properly
        plan.setUser(user);
        plan.setStatus("Active");
        PlanDetail planDetail = new PlanDetail(); // You may need to initialize PlanDetail properly
        Client client = new Client(); // You may need to initialize Client properly
        plan.setClient(client);

        // Get PlanDTO using a mapper, assuming you have one
        PlanDTO planDTO = planMapper.toDTO(plan);

        // Assertions
        assertNotNull(planDTO.getId());
        assertNotNull(planDTO.getCode());
        assertNotNull(planDTO.getNumberOfPeople());
        assertNotNull(planDTO.getStartDate());
        assertNotNull(planDTO.getEndDate());
        assertNotNull(planDTO.getTotalValue());
        assertNotNull(planDTO.getCreationDate());
        assertNotNull(planDTO.getUser());
        assertNotNull(planDTO.getStatus());
        assertNotNull(planDTO.getClient());
    }
}
