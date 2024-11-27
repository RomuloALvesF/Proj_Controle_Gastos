package com.romulo.controlegasto.repositories;

import com.romulo.controlegasto.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, UUID> {
    //findByEmail para buscaros registros
    //Optional<UsuarioModel>: Retorna um usuário opcional. Pode estar presente ou vazio.
    Optional<UsuarioModel> findByEmail(String email);
}
