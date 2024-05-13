package co.edu.icesi.sgiv.controller.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class AuthController {

    private final AuthService authService;

    @PostMapping (value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping (value = "/register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping (value = "/verify", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AuthResponse> verify(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }



}
