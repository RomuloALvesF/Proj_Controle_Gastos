package com.romulo.controlegasto.repositories;

import com.romulo.controlegasto.model.GastosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Repository
public interface GastosRepository extends JpaRepository<GastosModel, UUID> {
    List<GastosModel> findByContaId(UUID contaId);
    List<GastosModel> findByCategoriaId(UUID categoriaId);
    List<GastosModel> findByDataBetween(LocalDate startDate, LocalDate endDate);
}
