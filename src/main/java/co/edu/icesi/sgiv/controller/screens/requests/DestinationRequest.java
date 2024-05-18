package co.edu.icesi.sgiv.controller.screens.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DestinationRequest {

    private String name;
    private String code;
    private Long status;
    private Long type;
    int page;
    int size;
}
