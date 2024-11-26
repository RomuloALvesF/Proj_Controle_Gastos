package com.romulo.controlegasto.controller;

import com.romulo.controlegasto.converter.Converter;
import com.romulo.controlegasto.dto.CategoriaDTO;
import com.romulo.controlegasto.model.CategoriaModel;
import com.romulo.controlegasto.services.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<CategoriaDTO> categorias = categoriaService.findAll()
                .stream()
                .map(Converter::toCategoriaDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(categorias);
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> create(@RequestBody CategoriaDTO categoriaDTO) {
        CategoriaModel categoria = categoriaService.save(Converter.toCategoriaModel(categoriaDTO));
        return ResponseEntity.ok(Converter.toCategoriaDTO(categoria));
    }
}