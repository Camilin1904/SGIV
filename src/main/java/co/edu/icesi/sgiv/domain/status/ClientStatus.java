package co.edu.icesi.sgiv.domain.status;

import co.edu.icesi.sgiv.domain.entitie.Client;
import co.edu.icesi.sgiv.domain.entitie.Plan;
import co.edu.icesi.sgiv.domain.modification.ClientModification;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "client_status")
public class ClientStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Client> clients;
}
