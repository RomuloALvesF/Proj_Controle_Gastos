package com.romulo.controlegasto.services;

import com.romulo.controlegasto.model.UsuarioModel;
import com.romulo.controlegasto.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//criar uma interface para implementar nos services para quando precisarmos mudar algo mudamos apenas a interface
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioModel> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> findById(UUID id) {
        return usuarioRepository.findById(id);
    }

    public Optional<UsuarioModel> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public UsuarioModel save(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(UUID id) {
        usuarioRepository.deleteById(id);
    }
}
