package br.com.clinicacheckup.appcheckup.service;

import br.com.clinicacheckup.appcheckup.dto.AuthResponse;
import br.com.clinicacheckup.appcheckup.dto.LoginRequest;
import br.com.clinicacheckup.appcheckup.dto.RegisterRequest;
import br.com.clinicacheckup.appcheckup.exception.AuthException;
import br.com.clinicacheckup.appcheckup.mapper.UserMapper;
import br.com.clinicacheckup.appcheckup.model.User;
import br.com.clinicacheckup.appcheckup.repository.UserRepository;
import br.com.clinicacheckup.appcheckup.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserMapper userMapper;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByCpf(request.getCpf())
                .orElseThrow(() -> new AuthException("Credenciais inválidas"));
        
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new AuthException("Credenciais inválidas");
        }
        
        String token = jwtService.generateToken(user.getCpf());
        
        return AuthResponse.builder()
                .token(token)
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.findByCpf(request.getCpf()).isPresent()) {
            throw new AuthException("CPF já cadastrado");
        }
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new AuthException("E-mail já cadastrado");
        }

        User newUser = userMapper.toEntity(request);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        
        User savedUser = userRepository.save(newUser);
        
        // Mantemos o mock subject baseado no CPF
        String token = jwtService.generateToken(savedUser.getCpf());

        return AuthResponse.builder()
                .token(token)
                .email(savedUser.getEmail())
                .name(savedUser.getName())
                .build();
    }
}
