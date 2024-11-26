package com.romulo.controlegasto.repositories;

import com.romulo.controlegasto.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, UUID> {
    Optional<CategoriaModel> findByNome(String nome);
}
