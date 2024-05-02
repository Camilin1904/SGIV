package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.dto.status.ClientStatusDTO;

import java.sql.Date;
import java.util.List;


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

    public Long getId() {
        return id;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public UserDTO getUser() {
        return user;
    }

    public ClientStatusDTO getStatus() {
        return status;
    }

    public List<PlanDTO> getRequestedPlans() {
        return requestedPlans;
    }
}
