package com.example.animalapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("animais")
public class Animal {
    @Id
    private String id;
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private String pessoaId;
}
