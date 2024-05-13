package co.edu.icesi.sgiv.dto.entity;


import co.edu.icesi.sgiv.dto.status.UserStatusDTO;
import co.edu.icesi.sgiv.dto.type.UserTypeDTO;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationDTO {

    private String username;

    private String password;

    private Date creationDate;

    private String email;

    private UserTypeDTO type;
}
