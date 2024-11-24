package com.romulo.controlegasto.repositories;

import com.romulo.controlegasto.model.ContasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ContasRepository extends JpaRepository<ContasModel, UUID> {
}
