package co.edu.icesi.sgiv.controller.user;


import co.edu.icesi.sgiv.auth.AuthService;
import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.dto.entity.UserDTO;
import co.edu.icesi.sgiv.dto.type.IdentificationTypeDTO;
import co.edu.icesi.sgiv.repository.type.IdentificationTypeRepository;
import co.edu.icesi.sgiv.request.GetUserTypeRequest;
import co.edu.icesi.sgiv.response.GetUserTypeResponse;
import co.edu.icesi.sgiv.service.abstraction.entity.UserService;
import co.edu.icesi.sgiv.service.abstraction.type.IdentificationTypeService;
import co.edu.icesi.sgiv.service.implementation.entity.UserServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthService authService;

    @Autowired
    IdentificationTypeService identificationTypeService;

    @GetMapping(value = "/type", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> getUserType(@RequestBody GetUserTypeRequest getUserTypeRequest) {
        Optional<User> oUser = userService.findByUsername(getUserTypeRequest.getUsername());
        if(oUser.isPresent()){
            User user = oUser.get();
            GetUserTypeResponse response = new GetUserTypeResponse();
            response.setUserType(user.getType().getName());
            response.setNewToken(authService.renewToken(user.getUsername()).getToken());
            return ResponseEntity.status(200).body(response);
        }
        return ResponseEntity.status(400).body("Contraseña o nombre de usuario incorrectos");
    }

    @GetMapping(value = "/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Hola");
    }
    @GetMapping(value = "/get", produces = "application/json")
    public ResponseEntity<UserDTO> getUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<UserDTO> userDTOOptional = userService.findByID(user.getId());
        return userDTOOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/idTypes", produces = "application/json")
    public ResponseEntity<List<IdentificationTypeDTO>> getIdTypes(){
        return ResponseEntity.ok(identificationTypeService.findAll());
    }
}
