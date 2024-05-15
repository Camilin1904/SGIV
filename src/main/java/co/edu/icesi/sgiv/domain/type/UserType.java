package co.edu.icesi.sgiv.domain.type;

import co.edu.icesi.sgiv.domain.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_type")
public class UserType implements GrantedAuthority {
    @Getter
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

    @Override
    public String getAuthority() {
        return name;
    }
}
