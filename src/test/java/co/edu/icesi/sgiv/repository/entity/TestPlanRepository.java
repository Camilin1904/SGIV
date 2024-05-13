package co.edu.icesi.sgiv.repository.entity;

import co.edu.icesi.sgiv.domain.entity.Plan;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestPlanRepository {

    @Autowired
    private PlanRepository planRepository;

    @Test
    public void shouldReturnOnePlan(){
        System.out.println(planRepository.getMostPopularDestination().get());
        assertTrue(planRepository.getMostPopularDestination().isPresent());
    }


    //temporal test, will not work in the future
    //TODO: Implement these tests correctly
    @Test
    public void shouldReturnSomePlans(){
        System.out.println(new Date(System.currentTimeMillis()).toString());
        System.out.println(planRepository.findByCreationDate(new Date(System.currentTimeMillis())).size());
        for (Plan plan : planRepository.findByCreationDate(new Date(System.currentTimeMillis()))){
            System.out.println(plan.getId());
        }
        assertFalse(planRepository.findByCreationDate(new Date(System.currentTimeMillis())).isEmpty());
    }

    @Test
    public void shouldReturnMoreThanOne(){
        assert planRepository.countByCreationDate(new Date(System.currentTimeMillis())) == 3;
    }
}
