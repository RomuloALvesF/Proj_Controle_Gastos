package com.romulo.controlegasto.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class UsuarioDTO {

    private UUID id;
    @NotBlank(message = "O nome é obrigatório.")
    private String nome;
    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "Formato de email inválido.")
    private String email;

    @NotBlank(message = "A senha é obrigatória.")
    private String password;

    public UsuarioDTO() {
    }

    public UsuarioDTO(UUID id, String nome, String email, String password) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

