package co.edu.icesi.sgiv.auth;

import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.jwt.JwtService;
import co.edu.icesi.sgiv.repository.entity.UserRepository;
import co.edu.icesi.sgiv.repository.status.UserStatusRepository;
import co.edu.icesi.sgiv.repository.type.UserTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserTypeRepository userTypeRepository;
    private final UserStatusRepository userStatusRepository;
    private final UserRepository userRepository;

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse renewToken(String username){
        UserDetails user=userRepository.findByUsername(username).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();


        String token=jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();

    }
    public AuthResponse register(RegisterRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setCreationDate(new Date(new java.util.Date().getTime()));
        user.setType(userTypeRepository.findById(1L).get());
        user.setStatus(userStatusRepository.findById(1L).get());
        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
