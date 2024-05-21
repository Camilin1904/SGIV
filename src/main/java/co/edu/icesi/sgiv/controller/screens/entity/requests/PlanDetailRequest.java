package co.edu.icesi.sgiv.controller.screens.entity.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlanDetailRequest {
    String name;
    Integer daysUpper;
    Integer daysLower;
    Integer nightsUpper;
    Integer nightsLower;
    Double valueUpper;
    Double valueLower;
    String status;
    int page;
    int size;

}
