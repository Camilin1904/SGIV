package co.edu.icesi.sgiv.controller.screens.entity.requests;

import co.edu.icesi.sgiv.domain.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

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
