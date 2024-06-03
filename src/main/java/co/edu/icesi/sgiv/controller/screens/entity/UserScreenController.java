package co.edu.icesi.sgiv.controller.screens.entity;

import co.edu.icesi.sgiv.dto.entity.UserDTO;
import co.edu.icesi.sgiv.mapper.entity.UserMapper;
import co.edu.icesi.sgiv.request.UserRequest;
import co.edu.icesi.sgiv.service.abstraction.entity.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class UserScreenController {


    @Autowired
    UserService userService;

    final UserMapper userMapper = UserMapper.INSTANCE;

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
