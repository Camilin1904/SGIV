package co.edu.icesi.sgiv.domain.entity;

import co.edu.icesi.sgiv.domain.modification.DestinationModification;
import co.edu.icesi.sgiv.domain.status.DestinationStatus;
import co.edu.icesi.sgiv.domain.type.DestinationType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "code", nullable = false, unique = true, length = 50)
    private String code;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "creator_user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private DestinationStatus status;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private DestinationType type;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<DestinationModification> modifications;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PlanDetailDestination> planDetailDestinations;

    public Destination(String code, String name, Date creationDate, User user, DestinationStatus status, DestinationType type) {
        this.code = code;
        this.name = name;
        this.creationDate = creationDate;
        this.user = user;
        this.status = status;
        this.type = type;
    }
}
