package co.edu.icesi.sgiv.dto.entity;

import co.edu.icesi.sgiv.domain.entity.Hotel;
import co.edu.icesi.sgiv.domain.entity.PlanDetail;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccommodationDTO {

    private Long id;

    private Integer amountOfPeople;

    private HotelDTO hotel;

    private String status;
}
