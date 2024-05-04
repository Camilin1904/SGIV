package co.edu.icesi.sgiv.controller.user;


import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.service.implementation.entity.UserServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class UserController {
    @Autowired
    UserServiceImplementation userServiceImplementation;

    @GetMapping(value = "/type", consumes = "application/json")
    public ResponseEntity<String> getUserType(@RequestBody UserRequest userRequest) {
        Optional<User> oUser = userServiceImplementation.findByUsername(userRequest.getUsername());
        if(oUser.isPresent()){
            User user = oUser.get();
            return ResponseEntity.status(200).body(user.getType().getName());
        }
        return ResponseEntity.status(400).body("Contraseña o nombre de usuario incorrectos");
    }

    @GetMapping(value = "/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Hola");
    }
}
