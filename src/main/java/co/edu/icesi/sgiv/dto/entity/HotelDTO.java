package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.dto.resources.HotelImageDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {

    private Long id;

    private String name;

    private String address;

    private String phone;

    private String email;

    private String websiteUrl;

    private String status;

    private List<HotelImageDTO> images;
}
