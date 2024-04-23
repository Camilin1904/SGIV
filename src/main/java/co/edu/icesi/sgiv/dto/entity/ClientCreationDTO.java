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

}
