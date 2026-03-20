package br.com.clinicacheckup.appcheckup.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres")
    private String name;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "O formato do email deve ser válido")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 8, max = 16, message = "A senha deve ter entre 8 e 16 caracteres")
    private String password;

    @NotBlank(message = "O CPF é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve ter exatamente 11 dígitos numéricos")
    private String cpf;

    @NotBlank(message = "O número de telefone é obrigatório")
    @Pattern(regexp = "\\d{11,13}", message = "O número de telefone deve ter entre 11 e 13 dígitos")
    private String phoneNumber;

    @NotNull(message = "A data de nascimento é obrigatória")
    private LocalDate birthDate;
}
