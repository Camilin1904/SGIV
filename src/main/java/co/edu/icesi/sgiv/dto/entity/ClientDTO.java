package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.dto.status.ClientStatusDTO;
import lombok.Getter;

import java.sql.Date;
import java.util.List;

@Getter
public class ClientDTO {
    private Long id;
    private String identificationNumber;
    private String firstName;
    private String lastName;
    private String secondLastName;
    private String phone1;
    private String phone2;
    private String email;
    private Date birthDate;
    private String gender;
    private UserDTO user;
    private ClientStatusDTO status;
    private List<PlanDTO> requestedPlans;
}
