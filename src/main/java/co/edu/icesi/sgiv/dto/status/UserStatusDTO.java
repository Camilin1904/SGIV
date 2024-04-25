package co.edu.icesi.sgiv.dto.status;

import co.edu.icesi.sgiv.dto.entity.UserDTO;
import lombok.Getter;

import java.util.List;


@Getter
public class UserStatusDTO {

    private String name;

    private List<UserDTO> users;
}
