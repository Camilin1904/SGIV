package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.dto.status.ClientStatusDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ClientDTO {

    @Getter
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

    public Long getId() {
        return id;
    }
}
