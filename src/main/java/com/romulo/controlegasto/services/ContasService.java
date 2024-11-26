package com.romulo.controlegasto.services;

import com.romulo.controlegasto.model.ContasModel;
import com.romulo.controlegasto.repositories.ContasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContasService {

    private final ContasRepository contasRepository;

    public ContasService(ContasRepository contasRepository) {
        this.contasRepository = contasRepository;
    }

    public List<ContasModel> findAll() {
        return contasRepository.findAll();
    }

    public Optional<ContasModel> findById(UUID id) {
        return contasRepository.findById(id);
    }

    public List<ContasModel> findByUsuarioId(UUID usuarioId) {
        return contasRepository.findByUsuario_Id(usuarioId);
    }

    public ContasModel save(ContasModel conta) {
        return contasRepository.save(conta);
    }

    public void deleteById(UUID id) {
        contasRepository.deleteById(id);
    }
}
