package com.romulo.controlegasto.controller;

import com.romulo.controlegasto.dto.UsuarioRequestDTO;
import com.romulo.controlegasto.dto.UsuarioResponseDTO;
import com.romulo.controlegasto.model.UsuarioModel;
import com.romulo.controlegasto.converter.Converter;
import com.romulo.controlegasto.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Retornar todos os usuários (Saída -> ResponseDTO)
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> findAll() {
        List<UsuarioResponseDTO> usuarios = usuarioService.findAll()
                .stream()
                .map(Converter::toUsuarioResponseDTO) // Converte para o DTO de saída
                .collect(Collectors.toList());
        return ResponseEntity.ok(usuarios);
    }

    // Buscar um usuário por ID (Saída -> ResponseDTO)
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> findById(@PathVariable UUID id) {
        return usuarioService.findById(id)
                .map(Converter::toUsuarioResponseDTO) // Converte para o DTO de saída
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Criar um novo usuário (Entrada -> RequestDTO, Saída -> ResponseDTO)
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> create(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        UsuarioModel usuarioModel = usuarioService.save(Converter.toUsuarioModel(usuarioRequestDTO)); // Converte entrada para model
        return ResponseEntity.ok(Converter.toUsuarioResponseDTO(usuarioModel)); // Converte model para saída
    }

    // Excluir um usuário por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (usuarioService.findById(id).isPresent()) {
            usuarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Buscar usuário por email (Saída -> ResponseDTO)
    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioResponseDTO> findByEmail(@PathVariable String email) {
        return usuarioService.findByEmail(email)
                .map(Converter::toUsuarioResponseDTO) // Converte para o DTO de saída
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
