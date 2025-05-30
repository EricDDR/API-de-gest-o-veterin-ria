package com.example.pessoaapi.repository;

import com.example.pessoaapi.model.Pessoa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PessoaRepository extends MongoRepository<Pessoa, String> {
    boolean existsByCpf(String cpf);
}
