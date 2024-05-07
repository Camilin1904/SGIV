package co.edu.icesi.sgiv.mapper.entity;
import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.entity.Plan;
import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.domain.status.UserStatus;
import co.edu.icesi.sgiv.domain.type.UserType;
import co.edu.icesi.sgiv.dto.entity.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestUserMapper {

    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Test
    public void shouldNotHaveNullAttributes() {
        // Create a User object
        User user = new User();
        user.setId(1L);
        user.setUsername("username");
        user.setPassword("password");
        Date currentDate = new Date(System.currentTimeMillis());
        user.setCreationDate(currentDate);
        user.setEmail("user@example.com");
        UserStatus status = new UserStatus(); // You may need to initialize UserStatus properly
        user.setStatus(status);
        UserType type = new UserType(); // You may need to initialize UserType properly
        user.setType(type);

        // Get UserDTO using a mapper, assuming you have one
        UserDTO userDTO = userMapper.toDTO(user);

        // Assertions
        assertNotNull(userDTO.getId());
        assertNotNull(userDTO.getUsername());
        assertNotNull(userDTO.getCreationDate());
        assertNotNull(userDTO.getEmail());
        assertNotNull(userDTO.getStatus());
        assertNotNull(userDTO.getType());

    }
}
