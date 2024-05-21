package co.edu.icesi.sgiv.controller.screens.entity;

import co.edu.icesi.sgiv.service.abstraction.entity.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class HotelController {

    @Autowired
    private final HotelService hotelService;


}
