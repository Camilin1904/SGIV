package co.edu.icesi.sgiv.dto.modification;

import co.edu.icesi.sgiv.dto.entity.ClientDTO;
import co.edu.icesi.sgiv.dto.entity.UserDTO;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClientModificationDTO {

    private Long id;

    private Date date;

    private UserDTO user;

    private ClientDTO client;

}
