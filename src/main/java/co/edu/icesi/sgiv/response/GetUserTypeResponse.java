package co.edu.icesi.sgiv.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetUserTypeResponse {
    private String userType;
    private String newToken;
}
