package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.entity.Plan;
import co.edu.icesi.sgiv.domain.status.UserStatus;
import co.edu.icesi.sgiv.domain.type.UserType;
import co.edu.icesi.sgiv.dto.status.UserStatusDTO;
import co.edu.icesi.sgiv.dto.type.UserTypeDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

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
