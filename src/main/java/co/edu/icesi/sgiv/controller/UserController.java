package co.edu.icesi.sgiv.controller;

import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.service.implementation.entity.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
public class UserController {

    @Autowired
    UserServiceImplementation userServiceImplementation;

    @PostMapping (value = "/login", consumes = "application/json")
    public ResponseEntity<String> helloWorld(@RequestBody String[] loginUser) {
        String username = loginUser[0];
        String password = loginUser[1];
        Optional<User> oUser = userServiceImplementation.findByUsername(username);
        if(oUser.isPresent()){
            User user = oUser.get();
            if(Objects.equals(user.getPassword(), password)){
                return ResponseEntity.status(200).body(user.getUsername());
            }
            return ResponseEntity.status(400).body("Contraseña o nombre de usuario incorrectos");
        }
        return ResponseEntity.status(400).body("Contraseña o nombre de usuario incorrectos");
    }
}
