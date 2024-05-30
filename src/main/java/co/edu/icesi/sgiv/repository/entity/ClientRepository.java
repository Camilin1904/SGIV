    package co.edu.icesi.sgiv.repository.entity;

import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.domain.type.IdentificationType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.sql.Date;

public interface ClientRepository extends JpaRepository<Client, Long> {


    public List<Client> findClientsByIdentificationNumber(String id_num);

    public List<Client> findClientsByGender(String gender);

    public List<Client> findAll();

    @Query("select c from Client c where lower(c.firstName) like lower(?1)")
    public List<Client> findClientsByFirstName(String name);

    @Query("select c from Client c where lower(c.firstName) like lower(?1) and lower(c.lastName) like lower(?2)")
    public List<Client> findClientsByFirstAndLastName(String name, String surname);

    public Page<Client> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM client C WHERE" +
                   "(:idNum IS NULL OR C.identification_number = :idNum) AND" +
                   "(:bDateUpper IS NULL OR C.birth_date <= :bDateUpper) AND" +
                   "(:bDateLower IS NULL OR C.birth_date >= :bDateLower) AND" +
                   "(:status IS NULL OR C.status = :status)", nativeQuery = true)
    public Page<Client> findByFilter(@Param("idNum") String idNum, @Param("bDateLower") Date bDateLower, @Param("bDateUpper") Date bDateUpper, @Param("status") String status,  Pageable pageable);



}
