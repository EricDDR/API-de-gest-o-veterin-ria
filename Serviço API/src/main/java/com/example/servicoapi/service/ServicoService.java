package com.example.servicoapi.service;

import com.example.servicoapi.model.Servico;
import com.example.servicoapi.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    public Servico create(Servico servico) {
        return repository.save(servico);
    }

    public List<Servico> findAll() {
        return repository.findAll();
    }

    public Optional<Servico> findById(String id) {
        return repository.findById(id);
    }

    public Servico update(String id, Servico servico) {
        Servico existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        existing.setData(servico.getData());
        existing.setTipo(servico.getTipo());
        existing.setValor(servico.getValor());
        existing.setStatus(servico.getStatus());
        existing.setAnimalId(servico.getAnimalId());

        return repository.save(existing);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
