package co.edu.icesi.sgiv.dto.status;

import co.edu.icesi.sgiv.dto.entity.UserDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserStatusDTO {

    private Long id;

    private String name;
}
