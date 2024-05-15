package co.edu.icesi.sgiv.controller.screens;

import co.edu.icesi.sgiv.controller.auth.AuthResponse;
import co.edu.icesi.sgiv.controller.auth.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class HomeController {

    /*@PostMapping(value = "/start", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {

        return ResponseEntity.ok(authService.login(request));
    }*/
}
