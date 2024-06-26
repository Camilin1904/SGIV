package co.edu.icesi.sgiv.mapper.entity;
import co.edu.icesi.sgiv.domain.entity.PlanDetail;
import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.domain.status.PlanDetailStatus;
import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestPlanDetailMapper {

    private final PlanDetailMapper planDetailMapper = PlanDetailMapper.INSTANCE;

    @Test
    public void shouldNotHaveNullAttributes() {
        // Create a PlanDetail object
        PlanDetail planDetail = new PlanDetail();
        planDetail.setId(1L);
        planDetail.setFood("Food");
        planDetail.setAccommodation("Accommodation");
        planDetail.setTransportation("Transportation");
        planDetail.setTransfers("Transfers");
        planDetail.setValue(100.0);
        planDetail.setNumberOfNights(5);
        planDetail.setNumberOfDays(7);
        Date currentDate = new Date(System.currentTimeMillis());
        planDetail.setCreationDate(currentDate);
        User user = new User(); // You may need to initialize User properly
        planDetail.setUser(user);
        PlanDetailStatus status = new PlanDetailStatus(); // You may need to initialize PlanDetailStatus properly
        planDetail.setStatus(status);

        // Get PlanDetailDTO using a mapper, assuming you have one
        PlanDetailDTO planDetailDTO = planDetailMapper.toDTO(planDetail);

        // Assertions
        assertNotNull(planDetailDTO.getId());
        assertNotNull(planDetailDTO.getFood());
        assertNotNull(planDetailDTO.getAccommodation());
        assertNotNull(planDetailDTO.getTransportation());
        assertNotNull(planDetailDTO.getTransfers());
        assertNotNull(planDetailDTO.getValue());
        assertNotNull(planDetailDTO.getNumberOfNights());
        assertNotNull(planDetailDTO.getNumberOfDays());
        assertNotNull(planDetailDTO.getCreationDate());
        assertNotNull(planDetailDTO.getUser());
        assertNotNull(planDetailDTO.getStatus());

    }
}
