package co.edu.icesi.sgiv.domain.type;

import co.edu.icesi.sgiv.domain.entitie.Client;
import co.edu.icesi.sgiv.domain.entitie.Destination;
import co.edu.icesi.sgiv.domain.entitie.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "user_type")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<User> users;
}
