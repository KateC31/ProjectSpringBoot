package com.Inti.backend.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.Inti.backend.service.UsersService;
import com.Inti.backend.model.Users;
import com.Inti.backend.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsersService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users user) {
        userService.registerUser(user);
        return ResponseEntity.ok("Usuario registrado con éxito");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user) {
        UserDetails userDetails = userService.loadUserByUsername(user.getEmail());
        if (userDetails != null && passwordEncoder.matches(user.getPassword(), userDetails.getPassword())) {
            String token = jwtUtil.generateToken(userDetails.getUsername());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Credenciales inválidas");
    }

    @GetMapping("/resource")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> getProtectedResource() {
        return ResponseEntity.ok("Este es un recurso protegido!");
    }
}
