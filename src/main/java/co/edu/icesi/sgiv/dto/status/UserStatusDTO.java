package co.edu.icesi.sgiv.dto.status;

import co.edu.icesi.sgiv.dto.entity.UserDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class UserStatusDTO {

    private String name;

    private List<UserDTO> users;
}
