package com.romulo.controlegasto.controller;

import com.romulo.controlegasto.dto.UsuarioDTO;
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

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<UsuarioDTO> usuarios = usuarioService.findAll()
                .stream()
                .map(Converter::toUsuarioDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable UUID id) {
        return usuarioService.findById(id)
                .map(Converter::toUsuarioDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioModel usuario = usuarioService.save(Converter.toUsuarioModel(usuarioDTO));
        return ResponseEntity.ok(Converter.toUsuarioDTO(usuario));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (usuarioService.findById(id).isPresent()) {
            usuarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}