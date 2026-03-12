package br.com.clinicacheckup.appcheckup.security;

import org.springframework.stereotype.Service;

/**
 * Service para operações com Token JWT.
 * Implementação real será adicionada futuramente.
 */
@Service
public class JwtService {

    public String generateToken(String email) {
        // TODO: Implementar geração real com biblioteca JJWT ou Auth0
        return "mocked-jwt-token-for-" + email;
    }

    public boolean isTokenValid(String token) {
        // TODO: Implementar validação real
        return token != null && token.startsWith("mocked-jwt-token");
    }

    public String extractUsername(String token) {
        // TODO: Implementar extração real do subject
        if (token != null && token.contains("-for-")) {
            return token.split("-for-")[1];
        }
        return null;
    }
}
