package co.edu.icesi.sgiv.domain.status;

import co.edu.icesi.sgiv.domain.entity.Destination;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Entity
@Getter
@Setter
@Table(name = "destination_status")
public class DestinationStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Destination> destinations;
}
