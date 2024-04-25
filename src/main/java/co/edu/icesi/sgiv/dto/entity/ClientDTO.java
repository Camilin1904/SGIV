package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.dto.status.ClientStatusDTO;
import lombok.Getter;

import java.sql.Date;
import java.util.List;

@Getter
public class ClientDTO {

    private Long id;
    private String IDNumber;
    private String name;
    private String phone1;
    private String phone2;
    private String email;
    private Date birthDate;

    private UserDTO user;
    private ClientStatusDTO status;
    private List<PlanDTO> requestedPlans;

    public ClientDTO(String idNumber, String name, String phone1, String phone2, String email, Date birthDate, UserDTO user, ClientStatusDTO status, List<PlanDTO> requestedPlans) {

        this.IDNumber = idNumber;
        this.name = name;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;
        this.birthDate = birthDate;
        this.user = user;
        this.status = status;
        this.requestedPlans = requestedPlans;
    }
}
