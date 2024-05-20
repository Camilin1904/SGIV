package co.edu.icesi.sgiv.dto.entity;

import lombok.*;

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
}
