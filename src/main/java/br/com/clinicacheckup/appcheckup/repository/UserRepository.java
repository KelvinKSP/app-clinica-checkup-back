package br.com.clinicacheckup.appcheckup.repository;

import br.com.clinicacheckup.appcheckup.model.User;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface inicial para o repositório de usuários.
 * Preparada para futura extensão do JpaRepository.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByCpf(String cpf);
}
