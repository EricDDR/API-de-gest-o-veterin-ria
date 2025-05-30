package com.example.servicoapi.repository;

import com.example.servicoapi.model.Servico;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServicoRepository extends MongoRepository<Servico, String> {
}
