package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.dto.status.UserStatusDTO;
import co.edu.icesi.sgiv.dto.type.UserTypeDTO;

import java.sql.Date;
import java.util.List;

public class UserDTO {
    private Long id;

    private String username;

    private Date creationDate;

    private String email;

    private UserStatusDTO status;

    private UserTypeDTO type;

    private List<ClientDTO> createdClients;

    private List<PlanDetailDTO> createdPlanDetails;

    private List<DestinationDTO> createdDestinations;

    private List<PlanDTO> createdPlans;
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getEmail() {
        return email;
    }

    public UserStatusDTO getStatus() {
        return status;
    }

    public UserTypeDTO getType() {
        return type;
    }

    public List<ClientDTO> getCreatedClients() {
        return createdClients;
    }

    public List<PlanDetailDTO> getCreatedPlanDetails() {
        return createdPlanDetails;
    }

    public List<DestinationDTO> getCreatedDestinations() {
        return createdDestinations;
    }

    public List<PlanDTO> getCreatedPlans() {
        return createdPlans;
    }
}
