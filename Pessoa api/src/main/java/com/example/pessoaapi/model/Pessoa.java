package com.example.pessoaapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("pessoas")
public class Pessoa {
    @Id
    private String id;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
}
