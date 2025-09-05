package com.example.appcheckup.controller;

import com.example.appcheckup.model.Pessoa;
import com.example.appcheckup.repository.PessoaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaRepository repository;

    public PessoaController(PessoaRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/pessoas/criar")
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
        Pessoa salva = repository.save(pessoa);
        return ResponseEntity.ok(salva);
    }
}
