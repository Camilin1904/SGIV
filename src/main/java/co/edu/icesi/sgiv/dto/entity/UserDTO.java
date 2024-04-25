package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.dto.status.UserStatusDTO;
import co.edu.icesi.sgiv.dto.type.UserTypeDTO;

import java.sql.Date;
import java.util.List;

public class UserDTO {

    private String username;

    private Date creationDate;

    private String email;

    private UserStatusDTO status;

    private UserTypeDTO type;

    private List<ClientDTO> createdClients;

    private List<PlanDetailDTO> createdPlanDetails;

    private List<DestinationDTO> createdDestinations;

    private List<PlanDTO> createdPlans;
}
