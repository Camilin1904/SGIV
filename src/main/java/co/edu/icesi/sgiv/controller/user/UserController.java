package co.edu.icesi.sgiv.controller.user;


import co.edu.icesi.sgiv.auth.AuthService;
import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.domain.type.UserType;
import co.edu.icesi.sgiv.dto.entity.UserDTO;
import co.edu.icesi.sgiv.dto.type.IdentificationTypeDTO;
import co.edu.icesi.sgiv.dto.type.UserTypeDTO;
import co.edu.icesi.sgiv.repository.type.IdentificationTypeRepository;
import co.edu.icesi.sgiv.request.GetUserTypeRequest;
import co.edu.icesi.sgiv.request.UserRequest;
import co.edu.icesi.sgiv.response.GetUserTypeResponse;
import co.edu.icesi.sgiv.service.abstraction.entity.UserService;
import co.edu.icesi.sgiv.service.abstraction.type.IdentificationTypeService;
import co.edu.icesi.sgiv.service.abstraction.type.UserTypeService;
import co.edu.icesi.sgiv.service.implementation.entity.UserServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    UserTypeService userTypeService;

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

    @GetMapping(value = "/types", produces = "application/json")
    public ResponseEntity<List<UserTypeDTO>> getTypes(){
        //Find all
        return ResponseEntity.ok(userTypeService.findAll());
    }


    @PostMapping(value = "/page_user", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<UserDTO>> page_user(@RequestBody UserRequest userRequest) {
        Pageable pageable = PageRequest.of(userRequest.getPage(),userRequest.getSize());

        Page<UserDTO> user = userService.findByFilter(userRequest.getName(), userRequest.getType(),
                userRequest.getStatus(), pageable);

        return ResponseEntity.ok(user.toList());
    }

    @GetMapping(value = "/user_count", produces = "application/json")
    public ResponseEntity<Long> user_count() {
        return ResponseEntity.ok(userService.count());
    }


}
