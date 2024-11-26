package com.romulo.controlegasto.dto;

import java.util.UUID;

public class CategoriaDTO {
    private UUID id;
    private String nome;

    public CategoriaDTO() {
    }

    public CategoriaDTO(UUID id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

