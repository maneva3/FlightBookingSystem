package com.flightbookingsystem.web.api;

import com.flightbookingsystem.config.JwtAuthenticationResponse;
import com.flightbookingsystem.config.JwtTokenProvider;
import com.flightbookingsystem.config.LoginRequest;
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
@RequestMapping
public class LoginApiController {

    @GetMapping("/login")
    public ResponseEntity<?> getLoginPage() {
        return ResponseEntity.ok("Success");
    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        // Create an authentication token with the provided username and password
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        // Set the authentication in the security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Generate an authentication token (e.g., JWT)
        String token = jwtTokenProvider.generateToken(authentication);

        // Return the token as a response
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
