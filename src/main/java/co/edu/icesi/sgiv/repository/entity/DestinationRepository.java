package co.edu.icesi.sgiv.repository.entity;

import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.resources.DestinationImage;
import co.edu.icesi.sgiv.domain.type.DestinationType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DestinationRepository extends JpaRepository<Destination, Long> {

    public List<Destination> findAll();

    @Query("select d from Destination d inner join DestinationType dt on d.type = dt where dt.name = (?1)")
    public List<Destination> findDestinationsByDestinationTypeName(String dType);

    public List<Destination> findDestinationsByCode(String code);

    @Query("select d from Destination d join DestinationStatus dt where dt = ?1")
    public List<Destination> findDestinationsByDestinationType(DestinationType dt);


    @Query("select i from Destination d join DestinationImage i where d.id = ?1")
    public List<DestinationImage> getImages(Long id);


    public Page<Destination> findAll(Pageable pageable);

    public long count();


    @Query(value = "SELECT * FROM DESTINATION D WHERE"+
                   "(:name IS NULL OR D.name LIKE :name) AND" +
                   "(:code IS NULL OR D.CODE LIKE :name) AND" +
                   "(:status IS NULL OR D.status = :status) AND" +
                   "(:type IS NULL OR D.type_id = :type) ORDER BY D.NAME DESC", nativeQuery = true)
    public Page<Destination> findByFilter(@Param("name")String name, @Param("code") String code, @Param("status") String status, @Param("type") Long type, Pageable pageable);



}
