package co.edu.icesi.sgiv.dto.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TransportationDTO {

    private Long id;

    private String name;

    private String description;

    private String status;
}
