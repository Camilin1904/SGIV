package co.edu.icesi.sgiv.repository.entity;

import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.entity.Hotel;
import co.edu.icesi.sgiv.domain.resources.DestinationImage;
import co.edu.icesi.sgiv.domain.resources.HotelImage;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query("select i from Destination d join DestinationImage i where d.id = ?1")
    public List<HotelImage> getImages(Long id);

    @Query(value = "SELECT * FROM Hotel H WHERE " +
            "(:name IS NULL OR LOWER(H.NAME) LIKE '%'||LOWER(:name)||'%') AND" +
            "(:address IS NULL OR LOWER(H.ADDRESS) LIKE '%'||LOWER(:address)||'%') AND" +
            "(:status IS NULL OR H.STATUS = :status) AND" +
            "(:dID IS NULL OR H.DESTINATION = :dID)", nativeQuery = true)
    public Page<Hotel> findByFilter(Pageable pageable, @Param("name") String name, @Param("address") String address, @Param("status") String status, @Param("dID") Long dID);
}
