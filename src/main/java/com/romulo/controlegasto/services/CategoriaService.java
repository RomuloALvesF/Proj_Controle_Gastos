package com.romulo.controlegasto.services;

import com.romulo.controlegasto.model.CategoriaModel;
import com.romulo.controlegasto.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaModel> findAll() {
        return categoriaRepository.findAll();
    }

    public Optional<CategoriaModel> findById(UUID id) {
        return categoriaRepository.findById(id);
    }

    public Optional<CategoriaModel> findByNome(String nome) {
        return categoriaRepository.findByNome(nome);
    }

    public CategoriaModel save(CategoriaModel categoria) {
        return categoriaRepository.save(categoria);
    }

    public void deleteById(UUID id) {
        categoriaRepository.deleteById(id);
    }
}
