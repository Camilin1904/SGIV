package co.edu.icesi.sgiv.dto.status;

import co.edu.icesi.sgiv.dto.entity.ClientDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ClientStatusDTO {

    private String name;

    private List<ClientDTO> clients;
}
