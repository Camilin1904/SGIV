package co.edu.icesi.sgiv.repository.entity;

import co.edu.icesi.sgiv.domain.entity.Meals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealsRepository extends JpaRepository<Meals, Long> {
}
