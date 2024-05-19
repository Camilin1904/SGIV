package co.edu.icesi.sgiv.domain.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "destination")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "address", nullable = false, length = 500)
    private String address;

    @Column(name = "phone", nullable = false, length = 10)
    private String phone;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "website_url", nullable = false, length = 500)
    private String websiteUrl;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
    private List<Destination> destinations;

    @Column(name = "status", nullable = false)
    private String status;

}
