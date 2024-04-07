package co.edu.icesi.sgiv.domain.type;

import co.edu.icesi.sgiv.domain.entitie.Client;
import co.edu.icesi.sgiv.domain.entitie.Destination;
import co.edu.icesi.sgiv.domain.entitie.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "identification_type")
public class IdentificationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "code", nullable = false, length = 2)
    private String code;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @OneToMany(mappedBy = "identificationType", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Client> clients;
}
