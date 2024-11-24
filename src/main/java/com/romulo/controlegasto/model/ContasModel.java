package com.romulo.controlegasto.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_contas")
public class ContasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double balanco;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioModel usuarioModel;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GastosModel> gastos = new ArrayList<>();

    public ContasModel() {
    }

    public ContasModel(String nome, Double balanco, UsuarioModel usuarioModel) {
        this.nome = nome;
        this.balanco = balanco;
        this.usuarioModel = usuarioModel;
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

    public Double getBalanco() {
        return balanco;
    }

    public void setBalanco(Double balanco) {
        this.balanco = balanco;
    }

    public UsuarioModel getUsuario() {
        return usuarioModel;
    }

    public void setUsuario(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }

    public List<GastosModel> getGastos() {
        return gastos;
    }

    public void setGastos(List<GastosModel> gastos) {
        this.gastos = gastos;
    }

    // Método para adicionar um Gasto à Conta
    public void addGasto(GastosModel gasto) {
        gastos.add(gasto);
        gasto.setConta(this); // Atualiza o campo conta em Gastos
    }

    // Método para remover um Gasto da Conta
    public void removeGasto(GastosModel gasto) {
        gastos.remove(gasto);
        gasto.setConta(null); // Remove a referência da conta em Gastos
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContasModel contasModel = (ContasModel) o;
        return id.equals(contasModel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}



