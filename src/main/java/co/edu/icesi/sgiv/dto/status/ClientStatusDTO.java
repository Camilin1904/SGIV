package co.edu.icesi.sgiv.dto.status;

import co.edu.icesi.sgiv.dto.entity.ClientDTO;

import java.util.List;

public class ClientStatusDTO {

    private String name;

    private List<ClientDTO> clients;

    public String getName() {
        return name;
    }

    public List<ClientDTO> getClients() {
        return clients;
    }
}
