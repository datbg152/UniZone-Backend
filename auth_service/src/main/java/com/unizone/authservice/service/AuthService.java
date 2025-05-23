package com.unizone.authservice.service;
import com.unizone.authservice.jwt.RefreshTokenInfoRepository;
import com.unizone.authservice.dto.LoginRequest;
import com.unizone.authservice.jwt.JwtTokenProvider;
import com.unizone.authservice.jwt.JwtToken;
import com.unizone.authservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenInfoRepository refreshTokenInfoRepository;

    public JwtToken login(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getStudentId(),
                            loginRequest.getPassword()
                    )
            );

            // Generate JWT token
            JwtToken token = jwtTokenProvider.generateToken(authentication);

            // ✅ Save refresh token to Redis
            jwtTokenProvider.saveToken(token, authentication);

            return token;
        } catch (AuthenticationException e) {
            System.out.println(">>> AUTH FAILED: " + e.getMessage());
            throw new BadCredentialsException("Invalid username or password");
        }
    }
    public JwtToken refresh(String refreshToken) {
        return jwtTokenProvider.refreshToken(refreshToken);
    }

    public void logout(String refreshToken) {
        refreshTokenInfoRepository.deleteById(refreshToken);
    }
}