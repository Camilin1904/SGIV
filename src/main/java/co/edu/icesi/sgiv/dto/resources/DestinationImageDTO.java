package co.edu.icesi.sgiv.dto.resources;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DestinationImageDTO {
    private Long id;

    private String image;
}
