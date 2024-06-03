package co.edu.icesi.sgiv.repository.entity;

import co.edu.icesi.sgiv.domain.entity.Meals;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MealsRepository extends JpaRepository<Meals, Long> {
    @Query(value = "SELECT * FROM MEALS M WHERE" +
            "(:name IS NULL OR LOWER(M.NAME) LIKE '%'||LOWER(:name)||'%') AND" +
            "(:status IS NULL OR M.STATUS = :status)", nativeQuery = true)
    public Page<Meals> findByFilter(@Param("name") String name, @Param("status") String status, Pageable page);
}
