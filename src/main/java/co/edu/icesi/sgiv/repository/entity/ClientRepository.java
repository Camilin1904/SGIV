    package co.edu.icesi.sgiv.repository.entity;

import co.edu.icesi.sgiv.domain.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {


    public List<Client> findClientsByIdentificationNumber(String id_num);

    public List<Client> findClientsByGender(String gender);

    public List<Client> findAll();

    @Query("select c from Client c where lower(c.firstName) like lower(?1)")
    public List<Client> findClientsByFirstName(String name);

    @Query("select c from Client c where lower(c.firstName) like lower(?1) and lower(c.lastName) like lower(?2)")
    public List<Client> findClientsByFirstAndLastName(String name, String surname);

    public Page<Client> findAll(Pageable pageable);
}
