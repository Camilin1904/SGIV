package co.edu.icesi.sgiv.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlanRequest {

    String code;
    Double tvm;
    Double tvl;
    String status;
    int size;
    int page;
}
