package co.edu.icesi.sgiv.dto.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MealsDTO {

    private Long id;

    private String name;

    private String description;

    private String status;
}
