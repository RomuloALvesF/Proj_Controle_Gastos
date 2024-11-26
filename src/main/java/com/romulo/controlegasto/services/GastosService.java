package com.romulo.controlegasto.services;

import com.romulo.controlegasto.model.GastosModel;
import com.romulo.controlegasto.repositories.GastosRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GastosService {

    private final GastosRepository gastosRepository;

    public GastosService(GastosRepository gastosRepository) {
        this.gastosRepository = gastosRepository;
    }

    public List<GastosModel> findAll() {
        return gastosRepository.findAll();
    }

    public Optional<GastosModel> findById(UUID id) {
        return gastosRepository.findById(id);
    }

    public List<GastosModel> findByContaId(UUID contaId) {
        return gastosRepository.findByContaId(contaId);
    }

    public List<GastosModel> findByCategoriaId(UUID categoriaId) {
        return gastosRepository.findByCategoriaId(categoriaId);
    }

    public List<GastosModel> findByDateRange(LocalDate startDate, LocalDate endDate) {
        return gastosRepository.findByDataBetween(startDate, endDate);
    }

    public GastosModel save(GastosModel gasto) {
        return gastosRepository.save(gasto);
    }

    public void deleteById(UUID id) {
        gastosRepository.deleteById(id);
    }
}
