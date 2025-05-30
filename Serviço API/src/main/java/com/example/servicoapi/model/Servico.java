package com.example.servicoapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("servicos")
public class Servico {
    @Id
    private String id;
    private Date data;
    private String tipo;
    private double valor;
    private String status;
    private String animalId;
}
