package com.unizone.authservice.controller;

import com.unizone.authservice.dto.LoginRequest;
import com.unizone.authservice.dto.LogoutRequest;
import com.unizone.authservice.dto.RefreshTokenRequest;
import com.unizone.authservice.jwt.JwtToken;
import com.unizone.authservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtToken> login(@RequestBody LoginRequest loginRequest) {
        JwtToken token = authService.login(loginRequest);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtToken> refresh(@RequestBody RefreshTokenRequest request) {
        JwtToken newToken = authService.refresh(request.getRefreshToken());
        return ResponseEntity.ok(newToken);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestBody LogoutRequest request) {

        // Extract access token from header
        String accessToken = authorizationHeader.replace("Bearer ", "");

        // Optionally validate or blacklist access token (if real-time logout is needed)
        // For stateless JWT, this step is optional unless you use a blacklist

        // Delete refresh token from Redis
        authService.logout(request.getRefreshToken());

        return ResponseEntity.ok("Logged out successfully");
    }
}