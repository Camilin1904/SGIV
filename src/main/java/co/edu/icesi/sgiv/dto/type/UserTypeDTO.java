package co.edu.icesi.sgiv.dto.type;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserTypeDTO {

    private Long id;

    private String name;

    private String description;
}
