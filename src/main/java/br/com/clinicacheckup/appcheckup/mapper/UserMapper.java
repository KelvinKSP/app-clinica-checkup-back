package br.com.clinicacheckup.appcheckup.mapper;

import br.com.clinicacheckup.appcheckup.dto.RegisterRequest;
import br.com.clinicacheckup.appcheckup.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(RegisterRequest request) {
        if (request == null) {
            return null;
        }
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .cpf(request.getCpf())
                .phoneNumber(request.getPhoneNumber())
                .birthDate(request.getBirthDate())
                .build();
    }
}
