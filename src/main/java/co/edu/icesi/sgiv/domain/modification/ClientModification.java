package co.edu.icesi.sgiv.domain.modification;

import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.domain.entity.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Data
@Entity
@Getter
@Setter
@Table(name = "client_modification")
public class ClientModification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "date", nullable = false, updatable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "modifier_user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "modified_client_id", nullable = false)
    private Client client;
}
