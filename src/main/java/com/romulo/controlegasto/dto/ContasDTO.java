package com.romulo.controlegasto.dto;

import java.util.UUID;

public class ContasDTO {
    private UUID id;
    private String nome;
    private Double balanco;
    private UUID usuarioId;

    public ContasDTO() {
    }

    public ContasDTO(UUID id, String nome, Double balanco, UUID usuarioId) {
        this.id = id;
        this.nome = nome;
        this.balanco = balanco;
        this.usuarioId = usuarioId;
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

    public Double getBalanco() {
        return balanco;
    }

    public void setBalanco(Double balanco) {
        this.balanco = balanco;
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UUID usuarioId) {
        this.usuarioId = usuarioId;
    }
}

