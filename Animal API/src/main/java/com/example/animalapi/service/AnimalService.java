package com.example.animalapi.service;

import com.example.animalapi.model.Animal;
import com.example.animalapi.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository repository;

    public Animal create(Animal animal) {
        return repository.save(animal);
    }

    public List<Animal> findAll() {
        return repository.findAll();
    }

    public Optional<Animal> findById(String id) {
        return repository.findById(id);
    }

    public Animal update(String id, Animal animal) {
        Animal existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));

        existing.setNome(animal.getNome());
        existing.setEspecie(animal.getEspecie());
        existing.setRaca(animal.getRaca());
        existing.setIdade(animal.getIdade());
        existing.setPessoaId(animal.getPessoaId());

        return repository.save(existing);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
