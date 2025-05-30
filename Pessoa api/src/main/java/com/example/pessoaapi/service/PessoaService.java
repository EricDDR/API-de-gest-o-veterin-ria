package com.example.pessoaapi.service;

import com.example.pessoaapi.model.Pessoa;
import com.example.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public Pessoa create(Pessoa pessoa) {
        if (repository.existsByCpf(pessoa.getCpf())) {
            throw new RuntimeException("CPF já cadastrado");
        }
        return repository.save(pessoa);
    }

    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    public Optional<Pessoa> findById(String id) {
        return repository.findById(id);
    }

    public Pessoa update(String id, Pessoa pessoa) {
        Pessoa existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        existing.setNome(pessoa.getNome());
        existing.setCpf(pessoa.getCpf());
        existing.setTelefone(pessoa.getTelefone());
        existing.setEndereco(pessoa.getEndereco());

        return repository.save(existing);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
