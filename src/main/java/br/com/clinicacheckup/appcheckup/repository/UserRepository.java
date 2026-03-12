package br.com.clinicacheckup.appcheckup.repository;

import br.com.clinicacheckup.appcheckup.model.User;
import java.util.Optional;

/**
 * Interface inicial para o repositório de usuários.
 * Preparada para futura extensão do JpaRepository.
 */
public interface UserRepository {
    Optional<User> findByEmail(String email);
    User save(User user);
}
