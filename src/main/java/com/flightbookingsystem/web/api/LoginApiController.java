package com.flightbookingsystem.web.api;

import com.flightbookingsystem.config.JwtAuthenticationResponse;
import com.flightbookingsystem.config.JwtTokenProvider;
import com.flightbookingsystem.config.LoginRequest;
import com.flightbookingsystem.dto.UserDTO;
import com.flightbookingsystem.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/login")
public class LoginApiController {
    private final UserService userService;
    @GetMapping
    public ResponseEntity<?> getLoginPage() {
        return ResponseEntity.ok("Success");
    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
//        UserDTO userDTO = userService.getUser(loginRequest.getUsername());
//        if(userDTO == null){
//            return ResponseEntity.badRequest().body("User does not exist");
//        }
//        else if(!userDTO.getPassword().equals(loginRequest.getPassword())){
//            return ResponseEntity.badRequest().body("Incorrect password");
//        }
//        return ResponseEntity.ok("Success");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(){
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/unauthorized")
    public ResponseEntity<?> unauthorized(){
        return ResponseEntity.status(401).body("Unauthorized");
    }
}
