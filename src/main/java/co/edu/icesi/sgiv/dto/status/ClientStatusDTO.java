package co.edu.icesi.sgiv.dto.status;

import co.edu.icesi.sgiv.dto.entity.ClientDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClientStatusDTO {

    private Long id;

    private String name;

    private List<ClientDTO> clients;

}
