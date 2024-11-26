package com.romulo.controlegasto.controller;

import com.romulo.controlegasto.converter.Converter;
import com.romulo.controlegasto.dto.ContasDTO;
import com.romulo.controlegasto.model.ContasModel;
import com.romulo.controlegasto.model.UsuarioModel;
import com.romulo.controlegasto.services.ContasService;
import com.romulo.controlegasto.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contas")
public class ContasController {

    private final ContasService contasService;
    private final UsuarioService usuarioService;

    public ContasController(ContasService contasService, UsuarioService usuarioService) {
        this.contasService = contasService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<ContasDTO>> findAll() {
        List<ContasDTO> contas = contasService.findAll()
                .stream()
                .map(Converter::toContasDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(contas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContasDTO> findById(@PathVariable UUID id) {
        return contasService.findById(id)
                .map(Converter::toContasDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ContasDTO> create(@RequestBody ContasDTO contasDTO) {
        UsuarioModel usuario = usuarioService.findById(contasDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        ContasModel conta = contasService.save(Converter.toContasModel(contasDTO, usuario));
        return ResponseEntity.ok(Converter.toContasDTO(conta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (contasService.findById(id).isPresent()) {
            contasService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}