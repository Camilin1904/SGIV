package co.edu.icesi.sgiv.controller.home;

import co.edu.icesi.sgiv.dto.entity.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class HomeController {

    @GetMapping(value = "/admin", consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<UserDTO> admin(){
        return ResponseEntity.ok(new UserDTO());
    }

}
