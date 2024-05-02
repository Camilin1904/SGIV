package co.edu.icesi.sgiv.dto.status;

import co.edu.icesi.sgiv.dto.entity.UserDTO;

import java.util.List;


public class UserStatusDTO {

    private String name;

    private List<UserDTO> users;

    public String getName() {
        return name;
    }

    public List<UserDTO> getUsers() {
        return users;
    }
}
