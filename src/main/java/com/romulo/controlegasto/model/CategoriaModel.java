package com.romulo.controlegasto.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_categoria")
public class CategoriaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GastosModel> gastos = new ArrayList<>();

    public CategoriaModel() {
    }

    public CategoriaModel(String nome) {
        this.nome = nome;
    }

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

    public List<GastosModel> getGastos() {
        return gastos;
    }

    public void setGastos(List<GastosModel> gastos) {
        this.gastos = gastos;
    }

    // Método para adicionar um Gasto à Categoria
    public void addGasto(GastosModel gasto) {
        gastos.add(gasto);
        gasto.setCategoria(this); // Atualiza o campo categoria em Gastos
    }

    // Método para remover um Gasto da Categoria
    public void removeGasto(GastosModel gasto) {
        gastos.remove(gasto);
        gasto.setCategoria(null); // Remove a referência da categoria em Gastos
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaModel categoriaModel = (CategoriaModel) o;
        return id.equals(categoriaModel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}



