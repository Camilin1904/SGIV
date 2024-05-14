package co.edu.icesi.sgiv.repository.resources;

import co.edu.icesi.sgiv.domain.resources.DestinationImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinationImageRepository extends JpaRepository<DestinationImage, Long> {
    public List<DestinationImage> findByDestinationId(Long id);
}
