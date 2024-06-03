package co.edu.icesi.sgiv.repository.resources;

import co.edu.icesi.sgiv.domain.resources.DestinationImage;
import co.edu.icesi.sgiv.domain.resources.HotelImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelImageRepository extends JpaRepository<HotelImage, Long> {
    public List<HotelImage> findByHotelId(Long id);

}
