package co.edu.icesi.sgiv.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {
    String idNum;
    Date bDateLower;
    Date bDateUpper;
    String status;
    int page;
    int size;

}
