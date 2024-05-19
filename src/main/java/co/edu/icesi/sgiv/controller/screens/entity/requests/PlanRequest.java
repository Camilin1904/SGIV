package co.edu.icesi.sgiv.controller.screens.entity.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.query.Param;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlanRequest {

    String code;
    Double tvm;
    Double tvl;
    String clientName;
    String status;
    int size;
    int page;
}
