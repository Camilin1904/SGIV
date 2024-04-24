package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.dto.status.ClientStatusDTO;

import java.sql.Date;
import java.util.List;

public class ClientDTO {

    private String IDNumber;
    private String name;
    private String phone1;
    private String phone2;
    private String email;
    private Date birthDate;
    private ClientStatusDTO status;
    private List<PlanDTO> requestedPlans;

    public ClientDTO(String idNumber, String name, String phone1, String phone2, String email, Date birthDate, ClientStatusDTO status, List<PlanDTO> requestedPlans) {

        this.IDNumber = idNumber;
        this.name = name;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;
        this.birthDate = birthDate;
        this.status = status;
        this.requestedPlans = requestedPlans;
    }
}
