package br.com.clinicacheckup.appcheckup.service;

import br.com.clinicacheckup.appcheckup.dto.AuthResponse;
import br.com.clinicacheckup.appcheckup.dto.LoginRequest;
import br.com.clinicacheckup.appcheckup.dto.RegisterRequest;
import br.com.clinicacheckup.appcheckup.exception.AuthException;
import br.com.clinicacheckup.appcheckup.mapper.UserMapper;
import br.com.clinicacheckup.appcheckup.model.User;
import br.com.clinicacheckup.appcheckup.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserMapper userMapper;
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest request) {
        // Exemplo de uso da exceção customizada
        if (request.getEmail() == null || request.getPassword() == null) {
            throw new AuthException("Credenciais inválidas");
        }
        
        String token = jwtService.generateToken(request.getEmail());
        
        return AuthResponse.builder()
                .token(token)
                .email(request.getEmail())
                .name("User Mock")
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        User newUser = userMapper.toEntity(request);
        
        // Simulação de salvamento e geração de token
        String token = jwtService.generateToken(newUser.getEmail());

        return AuthResponse.builder()
                .token(token)
                .email(newUser.getEmail())
                .name(newUser.getName())
                .build();
    }
}
