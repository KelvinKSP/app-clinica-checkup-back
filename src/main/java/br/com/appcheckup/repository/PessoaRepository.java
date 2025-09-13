package br.com.appcheckup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.appcheckup.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
