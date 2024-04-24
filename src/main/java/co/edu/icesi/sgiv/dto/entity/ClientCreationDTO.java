package co.edu.icesi.sgiv.dto.entity;

import lombok.Getter;

import java.security.PrivateKey;
import java.sql.Date;

@Getter
public class ClientCreationDTO {
    private String idNumber;
    private String name;
    private String firstLastName;
    private String secondLastName;
    private String phone1;
    private String phone2;
    private String email;
    private String gender;
    private Date birthDate;
    private UserDTO creator;

    public ClientCreationDTO(String idNumber, String name, String firstLastName, String secondLastName, String phone1, String phone2, String email, String gender, Date birthDate, UserDTO creator) {
        this.idNumber = idNumber;
        this.name = name;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;
        this.gender = gender;
        this.birthDate = birthDate;
        this.creator = creator;
    }
}
