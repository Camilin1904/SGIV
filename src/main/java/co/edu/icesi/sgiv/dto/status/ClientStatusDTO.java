package co.edu.icesi.sgiv.dto.status;

import co.edu.icesi.sgiv.dto.entity.ClientDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class ClientStatusDTO {

    private String name;

    private List<ClientDTO> clients;

}
