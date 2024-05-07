package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.dto.status.UserStatusDTO;
import co.edu.icesi.sgiv.dto.type.UserTypeDTO;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;

    private String username;

    private Date creationDate;

    private String email;

    private UserStatusDTO status;

    private UserTypeDTO type;


}
