package co.edu.icesi.sgiv.controller.screens.entity;

import co.edu.icesi.sgiv.dto.entity.HotelDTO;
import co.edu.icesi.sgiv.dto.entity.MealsDTO;
import co.edu.icesi.sgiv.mapper.entity.MealsMapper;
import co.edu.icesi.sgiv.request.HotelRequest;
import co.edu.icesi.sgiv.request.MealRequest;
import co.edu.icesi.sgiv.service.abstraction.entity.MealsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meals")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class MealsController {

    @Autowired
    MealsService mealsService;

    final MealsMapper mealsMapper = MealsMapper.INSTANCE;

    @PostMapping(value = "/page_meals", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<MealsDTO>> page_meal(@RequestBody MealRequest mealRequest) {
        Pageable pageable = PageRequest.of(mealRequest.getPage(),mealRequest.getSize());

        Page<MealsDTO> meals = mealsService.findByFilter(mealRequest.getName(),
                mealRequest.getStatus(), pageable);
        System.out.println(meals);

        return ResponseEntity.ok(meals.toList());
    }

    @PostMapping(value = "/countFilter", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> countFilter(@RequestBody MealRequest mealRequest) {
        Pageable pageable = PageRequest.of(mealRequest.getPage(),mealRequest.getSize());

        Page<MealsDTO> meals = mealsService.findByFilter(mealRequest.getName(),
                mealRequest.getStatus(), pageable);
        System.out.println(meals);

        return ResponseEntity.ok(meals.getTotalPages());
    }

    @PostMapping(value = "/create", consumes = "application/json")
    public ResponseEntity<?> createMeal(@RequestBody MealsDTO meal) {
        try {
            mealsService.save(meal);
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/meals_count", produces = "application/json")
    public ResponseEntity<Long> meals_count() {
        return ResponseEntity.ok(mealsService.count());
    }

}
