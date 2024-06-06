package co.edu.icesi.sgiv.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelRequest {
    private String name;
    private String address;
    private String status;
    private Long dID;
    int page;
    int size;
}
