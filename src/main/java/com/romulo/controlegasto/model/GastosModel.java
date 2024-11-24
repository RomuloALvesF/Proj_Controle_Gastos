package com.romulo.controlegasto.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_gastos")
public class GastosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private CategoriaModel categoria;

    @ManyToOne
    @JoinColumn(name = "conta_id", nullable = false)
    private ContasModel conta;

    public GastosModel() {
    }

    public GastosModel(String descricao, Double preco, LocalDate data, CategoriaModel categoriaModel, ContasModel conta) {
        this.descricao = descricao;
        this.preco = preco;
        this.data = data;
        this.categoria = categoriaModel;
        this.conta = conta;
    }

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

    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoriaModel) {
        this.categoria = categoriaModel;
    }

    public ContasModel getConta() {
        return conta;
    }

    public void setConta(ContasModel conta) {
        this.conta = conta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GastosModel gastos = (GastosModel) o;
        return id.equals(gastos.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}



