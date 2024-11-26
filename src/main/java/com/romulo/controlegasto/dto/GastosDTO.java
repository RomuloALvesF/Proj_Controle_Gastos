package com.romulo.controlegasto.dto;

import java.time.LocalDate;
import java.util.UUID;

public class GastosDTO {
    private UUID id;
    private String descricao;
    private Double preco;
    private LocalDate data;
    private UUID categoriaId;
    private UUID contaId;

    public GastosDTO() {
    }

    public GastosDTO(UUID id, String descricao, Double preco, LocalDate data, UUID categoriaId, UUID contaId) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.data = data;
        this.categoriaId = categoriaId;
        this.contaId = contaId;
    }

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public UUID getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(UUID categoriaId) {
        this.categoriaId = categoriaId;
    }

    public UUID getContaId() {
        return contaId;
    }

    public void setContaId(UUID contaId) {
        this.contaId = contaId;
    }
}

